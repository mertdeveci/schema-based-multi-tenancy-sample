package com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MerchantLoginInitResponse extends Response {
    private String completeToken;

}
