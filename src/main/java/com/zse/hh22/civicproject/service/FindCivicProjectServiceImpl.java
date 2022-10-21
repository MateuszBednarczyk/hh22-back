package com.zse.hh22.civicproject.service;

import java.util.ArrayList;
import java.util.List;

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
class FindCivicProjectServiceImpl implements FindCivicProjectService {

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

    @Override
    public List<CivicProjectEntity> findAllCivicProjectEntitiesByCity(String city) {
        return civicProjectRepository.findAllByCityOrderByLikesDesc(city.toUpperCase()).orElse(List.of());
    }

    @Override
    public List<CivicProjectDTO> findAllCivicProjectsDTOsByCity(String city) {
        List<CivicProjectDTO> foundDTOs = new ArrayList<>();
        List<CivicProjectEntity> foundEntities = findAllCivicProjectEntitiesByCity(city);
        for (CivicProjectEntity civicProjectEntity : foundEntities) {
            foundDTOs.add(civicProjectMapper.mapEntityToDto(civicProjectEntity));
        }
        
        return foundDTOs;
    }

    @Override
    public List<CivicProjectDTO> findAllCivicProjectsDTOs() {
        List<CivicProjectDTO> foundDTOs = new ArrayList<>();
        civicProjectRepository.findAll().forEach(civicProjectEntity -> {
            foundDTOs.add(civicProjectMapper.mapEntityToDto(civicProjectEntity));
        });

        return foundDTOs;
    }
}

