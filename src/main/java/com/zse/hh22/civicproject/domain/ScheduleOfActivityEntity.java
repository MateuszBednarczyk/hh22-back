package com.zse.hh22.civicproject.domain;

import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zse.hh22.civicproject.api.CreateScheduleOfActivityDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "schedule_of_activities")
@NoArgsConstructor
public class ScheduleOfActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Year date;

    public ScheduleOfActivityEntity(CreateScheduleOfActivityDTO requestDTO) {
        this.title = requestDTO.title();
        this.description = requestDTO.description();
        this.date = requestDTO.date();
    }
}
