package com.github.mertdeveci.schemabasedmultitenancysample.presentation.controller;

import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response.Response;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchant.MerchantProductService;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchant.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/private/merchant-product")
@Slf4j
public class RestMerchantProductController {

    private final MerchantProductService merchantProductService;
    private final ResponseService responseService;

    @GetMapping
    public Response retrieveMerchantProducts() {
        merchantProductService.retrieveAllMerchantProducts();
        return responseService.prepareSuccessResponse();
    }
}
