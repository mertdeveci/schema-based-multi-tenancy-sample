package com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.security;

import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.repository.MerchantUserRepository;
import com.github.mertdeveci.schemabasedmultitenancysample.infrastructure.persistence.entity.MerchantUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MerchantUserRepository merchantUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Loading user by username: {}", username);
        MerchantUser merchantUser = merchantUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(merchantUser.getUsername())
                .password(merchantUser.getPassword())
                .roles("MERCHANT")
                .build();
    }
}
