package com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MerchantLoginCompleteResponse extends Response {
    private String token;

}
