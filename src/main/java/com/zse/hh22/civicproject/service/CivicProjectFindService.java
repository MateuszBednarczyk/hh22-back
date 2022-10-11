package com.zse.hh22.civicproject.service;

import com.zse.hh22.civicproject.domain.CivicProjectEntity;

public interface CivicProjectFindService {
    CivicProjectEntity findCivicProjectByTitle(String title);
}
