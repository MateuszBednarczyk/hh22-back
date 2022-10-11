package com.zse.hh22.civicproject.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record CreateEstimateDTO(@NotBlank(message = "Title cannot be null") String title,
                @NotBlank(message = "Description cannot be null") String description,
                @NotNull(message = "Cost cannot be null") Float cost) {
}
