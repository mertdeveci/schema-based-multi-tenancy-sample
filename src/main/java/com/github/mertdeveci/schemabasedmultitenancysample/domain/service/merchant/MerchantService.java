package com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchant;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.repository.MerchantRepository;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public Optional<Merchant> retrieveByClientId(String clientId) {
        return merchantRepository.findByClientId(clientId);
    }

}
