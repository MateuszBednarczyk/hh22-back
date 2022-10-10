package com.zse.hh22.user.api;

import javax.validation.constraints.Pattern;

public record UserRegisterDTO(String name, String surname, String email, String city,
                              @Pattern(regexp = "[\\d]{11}") String PESEL, String phoneNumber, String password) {
}
