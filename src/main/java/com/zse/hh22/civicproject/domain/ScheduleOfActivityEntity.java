package com.zse.hh22.civicproject.domain;

import com.zse.hh22.civicproject.api.CreateScheduleOfActivityDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Year;

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
