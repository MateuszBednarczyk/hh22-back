package com.zse.hh22.civicproject.service;

import com.zse.hh22.civicproject.api.CivicProjectDTO;
import com.zse.hh22.civicproject.domain.CivicProjectEntity;

public interface FindCivicProjectService {
    CivicProjectEntity findCivicProjectEntityByTitle(String title);
    CivicProjectDTO findCivicProjectEntityByTitleAndGetDTO(String title);
}
