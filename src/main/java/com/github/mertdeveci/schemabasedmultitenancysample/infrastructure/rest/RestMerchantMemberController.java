package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.rest;

import com.github.mertdeveci.schemabasedmultitenancysample.domain.manager.MerchantMemberManager;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/private/merchant/members")
@Slf4j
public class RestMerchantMemberController {

    private final MerchantMemberManager merchantMemberManager;

    @GetMapping
    public Response retrieveMerchantMembers() {
        return merchantMemberManager.retrieveMerchantMembers();
    }
}
