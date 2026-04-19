package com.github.mertdeveci.schemabasedmultitenancysample.presentation.controller;

import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.request.MerchantRegistrationRequest;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response.Response;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchant.MerchantService;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchant.ResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/public/merchant")
public class RestMerchantRegisterController {

    private final MerchantService merchantManager;
    private final ResponseService responseService;

    @PostMapping("/register")
    public Response createMerchant(@Valid @RequestBody MerchantRegistrationRequest request) {
        merchantManager.createMerchant(request);
        return responseService.prepareSuccessResponse();
    }
}
