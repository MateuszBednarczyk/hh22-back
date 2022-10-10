package com.zse.hh22.user.service;

import com.zse.hh22.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String pesel) throws UsernameNotFoundException {
        return userRepository.findByPesel(pesel).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
