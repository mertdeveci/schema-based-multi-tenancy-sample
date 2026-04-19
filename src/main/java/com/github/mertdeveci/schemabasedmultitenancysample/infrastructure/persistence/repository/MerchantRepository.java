package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.repository;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    Optional<Merchant> findByClientId(String clientId);
}
