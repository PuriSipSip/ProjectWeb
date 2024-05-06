package com.example.projectweb.services.activity;

import com.example.projectweb.dto.ActivityDTO;
import com.example.projectweb.entity.Activity;

import java.util.List;

public interface ActivityService {

    Activity postActivity(ActivityDTO activityDTO);

    List<Activity> getAllActivities();

    Activity getActivityById(Long id);

    Activity updateActivity(Long id, ActivityDTO activityDTO);

    void deleteActivity(Long id);
}
