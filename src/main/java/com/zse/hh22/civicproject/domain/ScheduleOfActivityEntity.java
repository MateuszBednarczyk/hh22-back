package com.zse.hh22.civicproject.domain;

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

    public ScheduleOfActivityEntity(String title, String description, Year date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }
}
