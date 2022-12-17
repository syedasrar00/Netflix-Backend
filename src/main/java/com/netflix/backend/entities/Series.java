package com.netflix.backend.entities;

import javax.persistence.*;
import java.util.List;
@Entity
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private int releaseYear;
    private String description;
    @OneToMany
    private List<Video> videos;
}
