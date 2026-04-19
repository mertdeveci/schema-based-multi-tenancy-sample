package com.github.mertdeveci.schemabasedmultitenancysample.application.mapper;

import com.github.mertdeveci.schemabasedmultitenancysample.application.dto.MerchantMemberDto;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.MerchantMemberVo;
import org.springframework.stereotype.Component;

@Component
public class MerchantMemberDtoMapper {

    public MerchantMemberDto dto(MerchantMemberVo vo) {
        MerchantMemberDto merchantMemberDto = new MerchantMemberDto();
        merchantMemberDto.setName(vo.name());
        merchantMemberDto.setSurname(vo.surname());
        merchantMemberDto.setEmail(vo.email());
        merchantMemberDto.setPhone(vo.phone());
        return merchantMemberDto;
    }
}
