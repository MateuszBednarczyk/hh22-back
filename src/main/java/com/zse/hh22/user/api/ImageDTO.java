package com.zse.hh22.user.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record ImageDTO(@NotBlank(message = "Image link cannot be null") @Size(max = 512)
                       String link) {
}

