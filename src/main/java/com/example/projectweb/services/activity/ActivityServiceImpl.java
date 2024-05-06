package com.example.projectweb.services.activity;

import com.example.projectweb.dto.ActivityDTO;
import com.example.projectweb.entity.Activity;
import com.example.projectweb.repository.ActivityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public Activity postActivity(ActivityDTO activityDTO) {
        return activityRepository.save(new Activity());
    }

    private Activity saveOrUpdateActivity(Activity activity, ActivityDTO activityDTO ) {
        activity.setActivity(activityDTO.getActivity());
        activity.setDescription(activityDTO.getDescription());
        activity.setDate(activityDTO.getDate());
        activity.setImage(activityDTO.getImage());
        activity.setTime(activityDTO.getTime());
        activity.setLocation(activityDTO.getLocation());

        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long id, ActivityDTO activityDTO){
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if(optionalActivity.isPresent()){
            return saveOrUpdateActivity(optionalActivity.get(), activityDTO);
        } else {
            throw new EntityNotFoundException("Activity is not present with id " + id);
        }
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll().stream()
                .sorted(Comparator.comparing(Activity::getId).reversed())
                .collect(Collectors.toList());
    }

    public Activity getActivityById(Long id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if (optionalActivity.isPresent()) {
            return optionalActivity.get();
        } else {
            throw new EntityNotFoundException("Activity not found with ID" + id);
        }
    }

    public void deleteActivity(Long id){
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if(optionalActivity.isPresent()) {
            activityRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Activity is not present with id " + id);
        }
    }
}
