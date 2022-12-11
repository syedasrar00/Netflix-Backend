package com.netflix.backend.entities;

import javax.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int profileId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
