package com.zse.hh22.security.configuration;

import com.zse.hh22.security.service.AuthenticationService;
import com.zse.hh22.security.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
class SecurityConfiguration {

    private final AuthenticationService authenticationService;
    private final AuthorizationService authorizationService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManager authenticationManager = authenticationManager(httpSecurity.getSharedObject(AuthenticationConfiguration.class));
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager, authenticationService);

        authenticationFilter.setFilterProcessesUrl("/api/v1/user");
        httpSecurity.addFilter(authenticationFilter);
        httpSecurity.addFilterBefore(new AuthorizationFilter(authorizationService), AuthenticationFilter.class);
        httpSecurity.cors();
        httpSecurity.csrf().disable();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/user").permitAll();
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/user/new").permitAll();

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

