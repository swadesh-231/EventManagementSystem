package com.spring.eventmanagementsystem.service;

import com.spring.eventmanagementsystem.entities.Event;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventsService {
    Event getEventById(int eventId) throws Exception;
    Event addEvent(Event event);
    Event updateEvent(Event event,int eventId);
    boolean deleteEvent(int eventId);
    List<Event> getAllEvents(Pageable pageable);
    Event searchEventByName(String eventName);
}
