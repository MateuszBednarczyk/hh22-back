package com.zse.hh22.civicproject.domain;

import com.zse.hh22.civicproject.api.CreateEstimateDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
