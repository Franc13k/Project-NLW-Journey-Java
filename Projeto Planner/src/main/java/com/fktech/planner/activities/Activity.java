
package com.fktech.planner.activities;

import jakarta.persistence.*;
import lombok.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fktech.planner.trip.Trip;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(name = "occurs_at", nullable = false)
    private LocalDateTime occursAt;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    public Activity(String title, String occursAt, Trip trip) {
        this.title = title;
        this.occursAt = LocalDateTime.parse(occursAt, DateTimeFormatter.ISO_DATE_TIME);
        this.trip = trip;
    }
}
