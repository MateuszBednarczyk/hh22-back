package com.zse.hh22.civicproject.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public record CreateScheduleOfActivityDTO(@NotBlank(message = "Title cannot be blank") String title,
                                          @NotBlank(message = "Description cannot be blank") String description,
                                          @NotBlank(message = "Date cannot be blank") @JsonFormat(pattern = "yyyy-MM") Date date) {
}
