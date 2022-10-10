package com.zse.hh22.civicproject.api;

import com.zse.hh22.user.api.UserDTO;

import java.util.List;

import javax.validation.constraints.NotBlank;

public record CreateCivicProjectDTO(@NotBlank(message = "Title cannot be blank") String title,
                                    @NotBlank(message = "City cannot be blank") String city,
                                    @NotBlank(message = "Description cannot be blank") String description,
                                    @NotBlank(message = "Justification cannot be blank") String justification,
                                    List<String> authors,
                                    List<UserDTO> likedBy,
                                    CreateEstimateDTO estimate,
                                    List<CreateScheduleOfActivityDTO> schedulesOfActivities) {
}
