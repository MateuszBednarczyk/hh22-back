package com.zse.hh22.civicproject.api;

import java.util.List;

import com.zse.hh22.user.api.UserDTO;

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
