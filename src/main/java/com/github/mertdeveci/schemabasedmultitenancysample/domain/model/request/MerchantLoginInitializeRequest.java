package com.github.mertdeveci.schemabasedmultitenancysample.domain.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantRegistrationRequest {

    @NotNull
    private String merchantName;

}
