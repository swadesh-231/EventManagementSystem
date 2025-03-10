package com.spring.eventmanagementsystem.repository;

import com.spring.eventmanagementsystem.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event,Integer>
{
    Event findByEventName(String eventName);
}
