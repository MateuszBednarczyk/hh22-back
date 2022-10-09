package com.zse.hh22.civicproject.domain;

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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private EstimateEntity estimate;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ScheduleOfActivityEntity> scheduleOfActivities;

    public CivicProjectEntity(String title, String city, String description, String justification, EstimateEntity estimate, List<ScheduleOfActivityEntity> scheduleOfActivities) {
        this.title = title;
        this.city = city;
        this.description = description;
        this.justification = justification;
        this.estimate = estimate;
        this.scheduleOfActivities = scheduleOfActivities;
    }
}
