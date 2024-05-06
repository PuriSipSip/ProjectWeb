package com.example.projectweb.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;

@Data

public class ActivityDTO {

    private Long id;

    private String activity;

    private String description;

    private String location;

    private LocalTime time;

    private LocalDate date;

     private String image;
    //MultipartFile
}
