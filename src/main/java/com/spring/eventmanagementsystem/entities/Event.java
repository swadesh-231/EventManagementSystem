package com.spring.eventmanagementsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventDate;
    private double ticketPrice;
    private int availableSeats;

}
