package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.security.filter;

import com.github.mertdeveci.schemabasedmultitenancysample.application.common.contants.MultitenantConstant;
import com.github.mertdeveci.schemabasedmultitenancysample.application.common.utils.JwtUtil;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.multitenancy.TenantContext;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.security.CustomUserDetailsService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    public JwtFilter(JwtUtil jwtUtil,
                     CustomUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String authHeader = request.getHeader("Authorization");

            if (authHeader != null && authHeader.startsWith("Bearer ")) {

                String token = authHeader.substring(7);

                String username = jwtUtil.extractUsername(token);
                String tenantName = jwtUtil.extractTenant(token);

                if (jwtUtil.isValid(token, username)) {

                    TenantContext.setTenant(tenantName);

                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                    var auth = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            } else {
                TenantContext.setTenant(MultitenantConstant.DEFAULT_TENANT);
            }

            filterChain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}