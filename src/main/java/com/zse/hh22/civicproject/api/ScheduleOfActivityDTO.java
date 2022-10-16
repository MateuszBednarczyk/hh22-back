package com.zse.hh22.civicproject.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Year;
import java.util.Date;

public record ScheduleOfActivityDTO(Long id, String title, String description, @JsonFormat(pattern = "yyyy-MM") Date date) {
}
