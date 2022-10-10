package com.zse.hh22.civicproject.api;

import java.time.Year;

public record ScheduleOfActivityDTO(Long id, String title, String description, Year date) {
}
