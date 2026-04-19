package com.github.mertdeveci.schemabasedmultitenancysample.domain.model.enums;

public enum ResponseStatus {
    SUCCESS("success"),
    ERROR("error"),
    FAIL("fail");

    private final String status;

    ResponseStatus(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }
}
