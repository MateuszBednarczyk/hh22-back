package com.zse.hh22.civicproject.domain;

import com.zse.hh22.civicproject.api.CreateCivicProjectDTO;
import com.zse.hh22.user.domain.Image;
import com.zse.hh22.user.domain.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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

    @NotBlank(message = "Short description cannot be blank")
    @Size(min = 10, max = 255, message = "Short description must be between 10 and 255 characters")
    private String shortDescription;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 255, max = 4096, message = "Description must be between 255 and 4096 characters")
    private String description;

    @NotBlank(message = "Justification cannot be blank")
    @Size(min = 50, max = 4096, message = "Justification must be between 50 and 4096 characters")
    private String justification;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<UserEntity> authors;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<UserEntity> likedBy;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<EstimateEntity> estimates;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ScheduleOfActivityEntity> schedulesOfActivities;

    @Enumerated(EnumType.ORDINAL)
    private CivicProjectState status;

    private int likes;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Image> images;

    @Enumerated(EnumType.ORDINAL)
    private CivicProjectCategory category;

    public CivicProjectEntity(CreateCivicProjectDTO requestDTO, List<UserEntity> authors, List<EstimateEntity> estimates,
                              List<ScheduleOfActivityEntity> schedulesOfActivities, List<Image> givenImages) {
        this.title = requestDTO.title();
        this.city = requestDTO.city().toUpperCase();
        this.shortDescription = requestDTO.shortDescription();
        this.description = requestDTO.description();
        this.justification = requestDTO.justification();
        this.authors = authors;
        this.estimates = estimates;
        this.schedulesOfActivities = schedulesOfActivities;
        this.status = CivicProjectState.UNVERIFIED;
        this.likes = 0;
        this.images = givenImages;
        this.category = CivicProjectCategory.valueOf(requestDTO.category().toUpperCase());
    }
}
