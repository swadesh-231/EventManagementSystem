package com.spring.eventmanagementsystem.service;

import com.spring.eventmanagementsystem.entities.Booking;

public interface BookingService {
    Booking bookEvent(Booking booking);

    Booking cancelBookedEvent(int bookingId, String status);
}
