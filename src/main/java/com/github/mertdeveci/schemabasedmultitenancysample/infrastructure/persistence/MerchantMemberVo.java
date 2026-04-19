package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence;

public record MerchantMemberVo(
        String name,
        String surname,
        String email,
        String phone
) {
}
