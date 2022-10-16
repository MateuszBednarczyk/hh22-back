package com.zse.hh22.civicproject.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "images_links")
@NoArgsConstructor
public class ImageLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String link;

    public ImageLink(String link) {
        this.link = link;
    }
}
