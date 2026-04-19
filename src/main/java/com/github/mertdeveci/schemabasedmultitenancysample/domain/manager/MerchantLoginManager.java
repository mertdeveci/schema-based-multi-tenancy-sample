package com.github.mertdeveci.schemabasedmultitenancysample.domain.manager;

import com.github.mertdeveci.schemabasedmultitenancysample.common.utils.JwtUtil;
import com.github.mertdeveci.schemabasedmultitenancysample.common.utils.ResponseBuilder;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.request.MerchantLoginCompleteRequest;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.request.MerchantLoginInitializeRequest;
import com.github.mertdeveci.schemabasedmultitenancysample.application.dto.MerchantLoginCompleteDto;
import com.github.mertdeveci.schemabasedmultitenancysample.application.dto.MerchantLoginInitializeDto;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response.Response;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchant.MerchantService;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchantuser.MerchantUserService;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.Merchant;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.MerchantUser;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MerchantLoginManager {

    private final MerchantService merchantService;
    private final MerchantUserService merchantUserService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ResponseBuilder responseBuilder;

    public Response initializeLogin(MerchantLoginInitializeRequest request) {
        log.info("Creating merchant with clientId: {}, clientSecret: {}", request.getClientId(), request.getClientSecret());
        Optional<Merchant> merchant = merchantService.retrieveByClientId(request.getClientId());
        if (merchant.isEmpty()) {
            throw new IllegalStateException("Merchant with clientId: " + request.getClientId() + " not found");
        }
        if (!passwordEncoder.matches(request.getClientSecret(), merchant.get().getClientSecret())) {
            throw new IllegalStateException("Passwords don't match");
        }
        String token = jwtUtil.generateLoginCompleteToken(merchant.get(), request.getMerchantUsername());
        MerchantLoginInitializeDto merchantLoginInitializeDto = new MerchantLoginInitializeDto(token);
        return responseBuilder.prepareSuccessResponse(merchantLoginInitializeDto);
    }

    public Response completeLogin(MerchantLoginCompleteRequest request, HttpServletRequest httpServletRequest, Principal principal) {
        log.info("Creating merchant with username: {}", principal.getName());
        MerchantUser merchantUser = merchantUserService.retrieveByUsername(principal.getName()).
                orElseThrow(() -> new IllegalStateException("Username not found"));
        String jwt = jwtUtil.generateToken(merchantUser, httpServletRequest);
        MerchantLoginCompleteDto merchantLoginCompleteDto = new MerchantLoginCompleteDto(jwt);
        return responseBuilder.prepareSuccessResponse(merchantLoginCompleteDto);

    }
}
