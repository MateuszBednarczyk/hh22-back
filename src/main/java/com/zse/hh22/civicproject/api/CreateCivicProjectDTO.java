package com.zse.hh22.civicproject.api;

import com.zse.hh22.user.api.ImageDTO;
import com.zse.hh22.user.api.UserDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public record CreateCivicProjectDTO(@NotBlank(message = "Title cannot be blank") String title,
                                    @NotBlank(message = "City cannot be blank") String city,

                                    @NotBlank(message = "Short description cannot be blank")
                                    @Size(min = 10, max = 255, message = "Short description must be between 10 and 255 characters")
                                    String shortDescription,
                                    @NotBlank(message = "Description cannot be blank")
                                    @Size(min = 255, max = 4096, message = "Description must be between 255 and 4096 characters")
                                    String description,
                                    @NotBlank(message = "Justification cannot be blank")
                                    @Size(min = 50, max = 4096, message = "Justification must be between 50 and 4096 characters")
                                    String justification,
                                    List<String> authors,
                                    List<UserDTO> likedBy,
                                    List<CreateEstimateDTO> estimates,
                                    List<CreateScheduleOfActivityDTO> schedulesOfActivities,
                                    List<ImageDTO> images,
                                    @NotBlank(message = "Category cannot be null") String category) {
}
