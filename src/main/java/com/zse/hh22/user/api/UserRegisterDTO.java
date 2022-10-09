package com.zse.hh22.user.api;

public record UserRegisterDTO(String name, String surname, String email, String city, Integer PESEL, Integer phoneNumber, String password) {
}
