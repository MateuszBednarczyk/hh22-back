package com.zse.hh22.civicproject.api;

import javax.validation.constraints.NotBlank;

public record ImageLinkDTO(@NotBlank(message = "Image link cannot be null") String link) {
}

