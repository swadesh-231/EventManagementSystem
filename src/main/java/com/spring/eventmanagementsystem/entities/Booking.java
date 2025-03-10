package com.spring.eventmanagementsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    private int bookingId;
    private int userId;
    private int eventId;
    private int numOfSeats;
    private double totalPrice;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

}
