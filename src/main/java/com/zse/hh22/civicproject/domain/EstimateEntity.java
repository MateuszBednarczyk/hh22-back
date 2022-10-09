package com.zse.hh22.civicproject.domain;

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

    public EstimateEntity(String title, String description, Float cost) {
        this.title = title;
        this.description = description;
        this.cost = cost;
    }
}
