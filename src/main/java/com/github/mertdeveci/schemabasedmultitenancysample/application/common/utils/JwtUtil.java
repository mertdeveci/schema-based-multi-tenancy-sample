package com.github.mertdeveci.schemabasedmultitenancysample.application.common.utils;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.Merchant;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.MerchantUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey123";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    private static final String TENANT = "tenant";

    public String generateLoginCompleteToken(Merchant merchant, String merchantUsername) {
        return Jwts.builder()
                .setSubject(merchantUsername)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .addClaims(
                        Map.of(
                                TENANT, merchant.getTenantName()
                        )
                )
                .compact();
    }

    public String generateToken(MerchantUser merchantUser, String tenant) {
        return Jwts.builder()
                .setSubject(merchantUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .addClaims(
                        Map.of(
                                TENANT, tenant,
                                "roles", List.of("ROLE_MERCHANT")
                                )
                )
                .compact();
    }

    public String generateToken(MerchantUser merchantUser, HttpServletRequest httpServletRequest) {
        String authHeader = httpServletRequest.getHeader("Authorization");
        String token = authHeader.substring(7);
        String tenant = extractTenant(token);

        return Jwts.builder()
                .setSubject(merchantUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .addClaims(
                        Map.of(
                                TENANT, tenant,
                                "roles", List.of("ROLE_MERCHANT")
                        )
                )
                .compact();
    }



    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean isValid(String token) {
        return !isExpired(token);
    }

    public boolean isValid(String token, String username) {
        return username.equals(extractUsername(token)) && !isExpired(token);
    }

    private boolean isExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractTenant(String token) {
        return extractClaim(token, claims -> claims.get(TENANT, String.class));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaims(token);
        return claimsResolver.apply(claims);
    }
}
