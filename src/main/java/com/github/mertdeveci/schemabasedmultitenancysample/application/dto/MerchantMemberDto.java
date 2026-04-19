package com.github.mertdeveci.schemabasedmultitenancysample.application.dto;

import lombok.Data;

@Data
public class MerchantMemberDto {
    private String name;
    private String surname;
    private String email;
    private String phone;
}
