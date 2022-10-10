package com.zse.hh22.civicproject.service;

import com.zse.hh22.civicproject.api.CreateCivicProjectDTO;
import com.zse.hh22.civicproject.domain.CivicProjectEntity;
import com.zse.hh22.civicproject.domain.EstimateEntity;
import com.zse.hh22.civicproject.domain.ScheduleOfActivityEntity;
import com.zse.hh22.civicproject.repository.CivicProjectRepository;
import com.zse.hh22.user.domain.UserEntity;
import com.zse.hh22.user.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
class CreateCivicProjectServiceImpl implements CreateCivicProjectService {

    private final CivicProjectRepository civicProjectRepository;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public void createProject(CreateCivicProjectDTO requestDTO) {
        civicProjectRepository.save(new CivicProjectEntity(requestDTO, getUserEntities(requestDTO), getEstimateEntity(requestDTO), getScheduleOfActivityEntities(requestDTO)));
    }

    private List<UserEntity> getUserEntities(CreateCivicProjectDTO requestDTO) {
        List<UserEntity> authors = new ArrayList<>();
        requestDTO.authors().forEach(dto -> {
            authors.add((UserEntity) userDetailsService.loadUserByUsername(dto));
        });

        return authors;
    }

    private static List<ScheduleOfActivityEntity> getScheduleOfActivityEntities(CreateCivicProjectDTO requestDTO) {
        List<ScheduleOfActivityEntity> scheduleOfActivities = new ArrayList<>();
        requestDTO.scheduleOfActivities().forEach(dto -> {
            scheduleOfActivities.add(new ScheduleOfActivityEntity(dto));
        });

        return scheduleOfActivities;
    }

    private static EstimateEntity getEstimateEntity(CreateCivicProjectDTO requestDTO) {
        EstimateEntity estimateEntity = new EstimateEntity(requestDTO.estimate());
        return estimateEntity;
    }
}
