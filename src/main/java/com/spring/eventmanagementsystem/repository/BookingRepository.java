package com.spring.eventmanagementsystem.repository;

import com.spring.eventmanagementsystem.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
