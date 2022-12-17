package com.netflix.backend.entities;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @OneToOne
    private Show show;
    @OneToOne
    private Video video;
}
