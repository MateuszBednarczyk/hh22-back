package com.zse.hh22.civicproject.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zse.hh22.civicproject.domain.CivicProjectState;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
class ManageCivicProjectServiceImpl implements ManageCivicProjectService {

    private final FindCivicProjectService findCivicProjectService;

    @Override
    public void setCivicProjectStateToVerified(String title) {
        findCivicProjectService.findCivicProjectEntityByTitle(title).setStatus(CivicProjectState.VERIFIED);
    }
}
    