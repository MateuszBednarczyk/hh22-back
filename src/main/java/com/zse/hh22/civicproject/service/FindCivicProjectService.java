package com.zse.hh22.civicproject.service;

import java.util.List;

import com.zse.hh22.civicproject.api.CivicProjectDTO;
import com.zse.hh22.civicproject.domain.CivicProjectEntity;

public interface FindCivicProjectService {
    CivicProjectEntity findCivicProjectEntityByTitle(String title);
    CivicProjectDTO findCivicProjectEntityByTitleAndGetDTO(String title);
    List<CivicProjectEntity> findAllCivicProjectEntitiesByCity(String city);
    List<CivicProjectDTO> findAllCivicProjectsDTOsByCity(String city);
    List<CivicProjectDTO> findAllCivicProjectsDTOs();
}
