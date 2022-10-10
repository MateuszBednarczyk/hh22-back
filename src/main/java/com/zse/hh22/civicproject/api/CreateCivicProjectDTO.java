package com.zse.hh22.civicproject.api;

import com.zse.hh22.user.api.UserDTO;

import java.util.List;

public record CreateCivicProjectDTO(String title,
                                    String city,
                                    String description,
                                    String justification,
                                    List<String> authors,
                                    List<UserDTO> likedBy,
                                    CreateEstimateDTO estimate,
                                    List<CreateScheduleOfActivityDTO> schedulesOfActivities) {
}

