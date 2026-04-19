package com.github.mertdeveci.schemabasedmultitenancysample.domain.manager;

import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.request.MerchantRegistrationRequest;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response.MerchantRegistrationResponse;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchant.MerchantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MerchantManager {

    private final MerchantService merchantService;

    public MerchantRegistrationResponse createMerchant(MerchantRegistrationRequest request) {
        log.info("Creating merchant with name: {}", request.getMerchantName());
        boolean merchantExists = merchantService.existsByName(request.getMerchantName());
        if (merchantExists) {
            throw new IllegalArgumentException("Merchant already exists");
        }
        return merchantService.createMerchant(request);
    }
}
