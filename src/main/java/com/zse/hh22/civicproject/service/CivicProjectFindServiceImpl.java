package com.zse.hh22.civicproject.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zse.hh22.civicproject.domain.CivicProjectEntity;
import com.zse.hh22.civicproject.exception.CivicProjectWithGivenTitleDoesNotExistsException;
import com.zse.hh22.civicproject.repository.CivicProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CivicProjectFindServiceImpl implements CivicProjectFindService {

    private final CivicProjectRepository civicProjectRepository;

    @Override
    public CivicProjectEntity findCivicProjectByTitle(String title) {
        return civicProjectRepository.findByTitle(title).orElseThrow(() -> new CivicProjectWithGivenTitleDoesNotExistsException());
    }
}

