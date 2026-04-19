package com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchant;

import com.github.mertdeveci.schemabasedmultitenancysample.domain.repository.MerchantRepository;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchantCreateService {

    private final MerchantRepository merchantRepository;

    public void createMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }

}
