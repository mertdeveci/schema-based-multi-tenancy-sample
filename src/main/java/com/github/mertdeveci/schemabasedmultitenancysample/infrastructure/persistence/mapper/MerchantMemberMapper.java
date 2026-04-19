package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.mapper;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.MerchantMemberVo;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.MerchantMember;
import org.springframework.stereotype.Component;

@Component
public class MerchantMemberMapper {

    public MerchantMemberVo vo(MerchantMember merchantMember) {
        return new MerchantMemberVo(
                merchantMember.getName(),
                merchantMember.getSurname(),
                merchantMember.getEmail(),
                merchantMember.getPhone()
        );
    }
}
