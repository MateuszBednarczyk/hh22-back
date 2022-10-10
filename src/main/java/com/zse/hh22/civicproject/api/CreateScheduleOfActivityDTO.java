package com.zse.hh22.civicproject.api;

import java.time.Year;

public record CreateScheduleOfActivityDTO(String title, String description, Year date) {
}
