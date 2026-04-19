package com.github.mertdeveci.schemabasedmultitenancysample.domain.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantLoginInitializeRequest {

    @NotNull
    @Size(min = 1, max = 100)
    private String clientId;

    @NotNull
    @Size(min = 1, max = 100)
    private String clientSecret;

}
