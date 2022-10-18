package com.zse.hh22;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import com.zse.hh22.user.api.UserRegisterDTO;
import com.zse.hh22.user.service.UserRegisterService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class Hh22Application {

    private final UserRegisterService userRegisterService;

    public static void main(String[] args) {
        SpringApplication.run(Hh22Application.class, args);
    }


    @Bean
    @Transactional
    @EventListener(Hh22Application.class)
    public void setupAdminUser(){
        userRegisterService.registerNewAdmin(new UserRegisterDTO("admin", "admin", "admin", "admin@admin.pl", "admin", "12345678912", "123456789", "admin"));
    }

}
