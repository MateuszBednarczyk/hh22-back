package com.zse.hh22.civicproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    private String title;
    private String description;
    private Float cost;

    public EstimateEntity(CreateEstimateDTO requestDTO) {
        this.title = requestDTO.title();
        this.description = requestDTO.description();
        this.cost = requestDTO.cost();
    }
}
