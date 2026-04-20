package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.config;

import com.github.mertdeveci.schemabasedmultitenancysample.application.common.utils.ResponseBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResponseBuilderConfig {

    @Bean
    public ResponseBuilder responseBuilder() {
        return new ResponseBuilder();
    }
}
