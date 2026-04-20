package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.multitenancy;

import com.github.mertdeveci.schemabasedmultitenancysample.application.common.contants.MultitenantConstant;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver<String> {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getTenant();
        return Objects.requireNonNullElse(tenant, MultitenantConstant.DEFAULT_TENANT);
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
