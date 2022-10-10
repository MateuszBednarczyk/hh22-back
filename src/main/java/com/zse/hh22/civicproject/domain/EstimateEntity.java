package com.zse.hh22.civicproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zse.hh22.civicproject.api.CreateEstimateDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "estimates")
@NoArgsConstructor
public class EstimateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Cost cannot be null")
    private Float cost;

    public EstimateEntity(CreateEstimateDTO requestDTO) {
        this.title = requestDTO.title();
        this.description = requestDTO.description();
        this.cost = requestDTO.cost();
    }
}
