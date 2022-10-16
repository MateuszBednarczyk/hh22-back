package com.zse.hh22.civicproject.api;

import com.zse.hh22.user.api.UserDTO;
import com.zse.hh22.user.api.ImageDTO;

import javax.validation.constraints.NotBlank;
import java.util.List;

public record CreateCivicProjectDTO(@NotBlank(message = "Title cannot be blank") String title,
                                    @NotBlank(message = "City cannot be blank") String city,

                                    @NotBlank(message = "Short description cannot be blank") String shortDescription,
                                    @NotBlank(message = "Description cannot be blank") String description,
                                    @NotBlank(message = "Justification cannot be blank") String justification,
                                    List<String> authors,
                                    List<UserDTO> likedBy,
                                    List<CreateEstimateDTO> estimates,
                                    List<CreateScheduleOfActivityDTO> schedulesOfActivities,
                                    List<ImageDTO> images,
                                    @NotBlank(message = "Category cannot be null") String category) {
}
