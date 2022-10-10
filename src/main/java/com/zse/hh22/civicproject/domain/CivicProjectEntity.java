package com.zse.hh22.civicproject.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.zse.hh22.civicproject.api.CreateCivicProjectDTO;
import com.zse.hh22.user.domain.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "civic_projects")
@NoArgsConstructor
public class CivicProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Justification cannot be blank")
    private String justification;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<UserEntity> authors;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<UserEntity> likedBy;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private EstimateEntity estimate;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ScheduleOfActivityEntity> schedulesOfActivities;

    public CivicProjectEntity(CreateCivicProjectDTO requestDTO, List<UserEntity> authors, EstimateEntity estimate, List<ScheduleOfActivityEntity> schedulesOfActivities) {
        this.title = requestDTO.title();
        this.city = requestDTO.city();
        this.description = requestDTO.description();
        this.justification = requestDTO.justification();
        this.authors = authors;
        this.estimate = estimate;
        this.schedulesOfActivities = schedulesOfActivities;
    }
}
