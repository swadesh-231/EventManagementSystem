package com.spring.eventmanagementsystem.controller;

import com.spring.eventmanagementsystem.entities.Event;
import com.spring.eventmanagementsystem.service.EventsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events/admin")
public class AdminController {

    private EventsService service;

    public AdminController(EventsService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Event addEvent(@RequestBody Event event) {

        return service.addEvent(event);
    }

    @PutMapping("/update/{eventId}")
    public Event updateEvent(@RequestBody Event event, @PathVariable int eventId) {
        return service.updateEvent(event, eventId);
    }

    @DeleteMapping("/delete/{eventId}")
    public boolean deleteEvent(@PathVariable int eventId) {
        return service.deleteEvent(eventId);
    }

}
