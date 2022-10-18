package com.zse.hh22.user.api;

import com.zse.hh22.user.domain.Role;

public record UserDTO(String firstName, String secondName, String surname, String email, String city, String pesel, String phoneNumber, Role role) {
}
