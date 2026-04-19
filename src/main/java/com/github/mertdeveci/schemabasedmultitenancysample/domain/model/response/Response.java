package com.github.mertdeveci.schemabasedmultitenancysample.domain.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private boolean success;
    private String message;
    private String errorCode;
    private String local;
    private long systemTime;
    private Object data;
}
