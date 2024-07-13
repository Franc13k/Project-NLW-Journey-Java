package com.fktech.planner.activities;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fktech.planner.trip.Trip;


public class ActivityService {
    
    @Autowired
    private ActivityRepository repository;
    
    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip){
        Activity newActivity = new Activity(payload.title(), payload.occurs_at(), trip);

        this.repository.save(newActivity);

        return new ActivityResponse(newActivity.getId());
    }

    public List<ActivityData> getAllActivityFromId(UUID tripId) {
        return this.repository.findByTripId(tripId).stream().map(activity -> new ActivityData(activity.getId(), activity.getTitle(), activity.getOccursAt())).toList();
    }
}
