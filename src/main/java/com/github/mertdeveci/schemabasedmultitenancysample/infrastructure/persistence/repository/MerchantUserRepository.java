package com.github.mertdeveci.schemabasedmultitenancysample.domain.repository;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.MerchantUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantUserRepository extends JpaRepository<MerchantUser, Long> {

    Optional<MerchantUser> findByEmail(String email);
}
