package com.example.projectweb.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String activity;
    private String description;
    private String location;
    private LocalTime time;
    private LocalDate date;
    @Lob     @Column
    private String image;



}
