package com.spring.eventmanagementsystem.service;

import com.spring.eventmanagementsystem.entities.Booking;
import com.spring.eventmanagementsystem.entities.BookingStatus;
import com.spring.eventmanagementsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository repo;

    public BookingServiceImpl(BookingRepository repo) {
        this.repo = repo;
    }

    @Override
    public Booking bookEvent(Booking booking) {
        return repo.save(booking);
    }

    @Override
    public Booking cancelBookedEvent(int bookingId,String status) {
        Booking booking=null;
        try {
            booking = repo.findById(bookingId).orElseThrow(()->new Exception("Booking not found"));
            booking.setBookingStatus(BookingStatus.CANCELLED);
            repo.save(booking);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return booking;
    }

}