package com.github.mertdeveci.schemabasedmultitenancysample.domain.repository;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.MerchantMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantMemberRepository extends JpaRepository<MerchantMember, Long> {
}
