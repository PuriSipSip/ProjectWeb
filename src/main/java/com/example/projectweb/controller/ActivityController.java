package com.example.projectweb.controller;

import com.example.projectweb.dto.ActivityDTO;
import com.example.projectweb.entity.Activity;
import com.example.projectweb.services.activity.ActivityService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<?> postActivity(@RequestBody ActivityDTO dto) {
        Activity createdActivity = activityService.postActivity(dto);
        if(createdActivity != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdActivity);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllActivities() {
        return ResponseEntity.ok(activityService.getAllActivities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActivities(@PathVariable long id) {
        try {
            return ResponseEntity.ok(activityService.getActivityById(id));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
