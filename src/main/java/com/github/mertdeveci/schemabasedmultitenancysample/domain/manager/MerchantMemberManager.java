package com.github.mertdeveci.schemabasedmultitenancysample.domain.manager;

import com.github.mertdeveci.schemabasedmultitenancysample.application.dto.MerchantMemberDto;
import com.github.mertdeveci.schemabasedmultitenancysample.application.mapper.MerchantMemberDtoMapper;
import com.github.mertdeveci.schemabasedmultitenancysample.application.common.utils.ResponseBuilder;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response.Response;
import com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchantmember.MerchantMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MerchantMemberManager {

    private final MerchantMemberService merchantMemberService;
    private final MerchantMemberDtoMapper merchantMemberDtoMapper;
    private final ResponseBuilder responseBuilder;

    public Response retrieveMerchantMembers() {
        List<MerchantMemberDto> merchantMemberDtoList = merchantMemberService
                .retrieveMerchantMembers()
                .stream()
                .map(merchantMemberDtoMapper::dto)
                .toList();
        return responseBuilder.prepareSuccessResponse(merchantMemberDtoList);
    }
}
