package com.zse.hh22.user.api;

import javax.validation.constraints.NotBlank;

public record ImageDTO(@NotBlank(message = "Image link cannot be null") String link) {
}

