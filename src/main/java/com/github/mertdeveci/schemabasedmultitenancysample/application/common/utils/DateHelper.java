package com.github.mertdeveci.schemabasedmultitenancysample.application.common.utils;

import java.util.Date;

public final class DateHelper {

    private DateHelper() {
    }

    public static Date now(){
        return new Date();
    }
}
