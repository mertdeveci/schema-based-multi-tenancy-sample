package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.repository;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.MerchantMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantMemberRepository extends JpaRepository<MerchantMember, Long> {
    Optional<MerchantMember> findByEmail(String email);
}
