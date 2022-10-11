package com.zse.hh22.civicproject.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zse.hh22.civicproject.api.CivicProjectDTO;
import com.zse.hh22.civicproject.domain.CivicProjectEntity;
import com.zse.hh22.civicproject.exception.CivicProjectWithGivenTitleDoesNotExistsException;
import com.zse.hh22.civicproject.mapper.CivicProjectMapper;
import com.zse.hh22.civicproject.repository.CivicProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class FindCivicProjectServiceImpl implements FindCivicProjectService {

    private final CivicProjectRepository civicProjectRepository;
    private final CivicProjectMapper civicProjectMapper;

    @Override
    public CivicProjectEntity findCivicProjectEntityByTitle(String title) {
        return civicProjectRepository.findByTitle(title).orElseThrow(() -> new CivicProjectWithGivenTitleDoesNotExistsException());
    }

    @Override
    public CivicProjectDTO findCivicProjectEntityByTitleAndGetDTO(String title) {
        return civicProjectMapper.mapEntityToDto(findCivicProjectEntityByTitle(title));
    }
}

