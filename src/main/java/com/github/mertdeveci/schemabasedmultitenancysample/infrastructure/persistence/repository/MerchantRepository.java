package com.github.mertdeveci.schemabasedmultitenancysample.domain.repository;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
