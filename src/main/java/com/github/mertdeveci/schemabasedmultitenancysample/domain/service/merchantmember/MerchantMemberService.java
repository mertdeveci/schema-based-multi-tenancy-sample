package com.github.mertdeveci.schemabasedmultitenancysample.domain.service.merchantmember;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.MerchantMemberVo;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.MerchantMember;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.mapper.MerchantMemberMapper;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.repository.MerchantMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MerchantMemberService {

    private final MerchantMemberRepository merchantMemberRepository;
    private final MerchantMemberMapper merchantMemberMapper;

    public List<MerchantMemberVo> retrieveMerchantMembers() {
        return merchantMemberRepository.findAll()
                .stream()
                .map(merchantMemberMapper::vo)
                .toList();
    }
}
