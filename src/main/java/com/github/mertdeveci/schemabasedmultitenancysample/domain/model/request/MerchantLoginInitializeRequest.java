package com.github.mertdeveci.schemabasedmultitenancysample.domain.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantLoginInitializeRequest {

    @NotNull
    private String merchantUsername;

    @NotNull
    private String clientId;

    @NotNull
    private String clientSecret;
}
