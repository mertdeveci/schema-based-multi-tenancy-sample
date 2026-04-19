package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver<String> {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getTenant();
        return Objects.requireNonNullElse(tenant, "public");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
