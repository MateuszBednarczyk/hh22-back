package com.zse.hh22.user.api;

import javax.validation.constraints.Pattern;

public record UserCredentialsDTO(@Pattern(regexp = "[\\d]{11}") String PESEL, String password) {
}

