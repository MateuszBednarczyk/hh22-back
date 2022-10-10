package com.zse.hh22.civicproject.domain;

import com.zse.hh22.civicproject.api.CreateCivicProjectDTO;
import com.zse.hh22.user.domain.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "civic_projects")
@NoArgsConstructor
public class CivicProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String city;
    private String description;
    private String justification;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<UserEntity> authors;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<UserEntity> likedBy;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private EstimateEntity estimate;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ScheduleOfActivityEntity> scheduleOfActivities;

    public CivicProjectEntity(CreateCivicProjectDTO requestDTO, List<UserEntity> authors, EstimateEntity estimate, List<ScheduleOfActivityEntity> scheduleOfActivities) {
        this.title = requestDTO.title();
        this.city = requestDTO.city();
        this.description = requestDTO.description();
        this.justification = requestDTO.justification();
        this.authors = authors;
        this.estimate = estimate;
        this.scheduleOfActivities = scheduleOfActivities;
    }
}
