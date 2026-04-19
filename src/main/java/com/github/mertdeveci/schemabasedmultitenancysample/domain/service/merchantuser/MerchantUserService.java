package com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchantuser;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.MerchantUser;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.repository.MerchantRepository;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.repository.MerchantUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MerchantUserService {

    private final MerchantUserRepository merchantUserRepository;

    public Optional<MerchantUser> retrieveByUsername(String username) {
        return merchantUserRepository.findByUsername(username);
    }
}
