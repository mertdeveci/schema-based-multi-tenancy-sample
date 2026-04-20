package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.rest;

import com.github.mertdeveci.schemabasedmultitenancysample.domain.manager.MerchantLoginManager;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.request.MerchantLoginCompleteRequest;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.request.MerchantLoginInitializeRequest;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/public/login")
public class RestMerchantController {

    private final MerchantLoginManager merchantLoginManager;

    @PostMapping("/initialize")
    public Response initializeLogin(@Valid @RequestBody MerchantLoginInitializeRequest request) {
        return merchantLoginManager.initializeLogin(request);
    }

    @PostMapping("/complete")
    public Response completeLogin(@Valid @RequestBody MerchantLoginCompleteRequest request, HttpServletRequest httpServletRequest, Principal principal) {
        return merchantLoginManager.completeLogin(request, httpServletRequest, principal);
    }
}
