package com.zse.hh22.user.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record UserRegisterDTO(
        @NotBlank(message = "Name cannot be blank") String name,
        @NotBlank(message = "Surname cannot be blank") String surname,
        @Email(message = "Email should be valid") @NotBlank(message = "Email cannot be blank") String email,
        @NotBlank(message = "City cannot be null") String city,
        @Pattern(regexp = "[\\d]{11}") String pesel,
        @NotBlank(message = "Phone number cannot be blank") String phoneNumber,
        @NotBlank(message = "Password cannot be blank") String password) {
}
