package com.zse.hh22.civicproject.api;

import com.zse.hh22.user.api.UserDTO;

import java.util.List;

public record CivicProjectDTO(Long id,
                              String title,
                              String city,
                              String description,
                              String justification,
                              List<UserDTO> authors,
                              List<UserDTO> likedBy,
                              EstimateDTO estimate,
                              List<ScheduleOfActivityDTO> schedulesOfActivities) {
}
