package com.zse.hh22.civicproject.api;

import com.zse.hh22.civicproject.domain.CivicProjectState;
import com.zse.hh22.user.api.UserDTO;

import java.util.List;

public record CivicProjectDTO(Long id,
                              String title,
                              String city,
                              String shortDescription,
                              String description,
                              String justification,
                              List<UserDTO> authors,
                              List<UserDTO> likedBy,
                              List<EstimateDTO> estimates,
                              List<ScheduleOfActivityDTO> schedulesOfActivities,
                              CivicProjectState status,
                              int likes) {

}
