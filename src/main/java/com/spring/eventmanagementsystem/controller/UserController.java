package com.spring.eventmanagementsystem.controller;

import com.spring.eventmanagementsystem.entities.Booking;
import com.spring.eventmanagementsystem.entities.Event;
import com.spring.eventmanagementsystem.service.BookingService;
import com.spring.eventmanagementsystem.service.EventsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events/user")
public class UserController {

    private EventsService service;
    private BookingService bookingService;

    public UserController(EventsService service, BookingService bookingService) {
        this.service = service;
        this.bookingService = bookingService;
    }

    @GetMapping("/all")
    public List<Event> getAllEvents(@RequestParam(defaultValue="0") int page,
                                    @RequestParam(defaultValue="5") int size,
                                    @RequestParam(defaultValue="price") String sortBy,
                                    @RequestParam(defaultValue="true") boolean ascending) {

        Sort sort = ascending ? Sort.by(sortBy).ascending() :  Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size,sort);
        return  service.getAllEvents(pageable);
    }


    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable int eventId) throws Exception {

        return service.getEventById(eventId);
    }


    @GetMapping("/search")
    public Event searchEventByName(@RequestParam String eventName) {

        return service.searchEventByName(eventName);
    }

    @PostMapping("/book")
    public Booking bookEvent(@RequestBody Booking booking)
    {
        return bookingService.bookEvent(booking);
    }

    @GetMapping("/cancel/{bookingId}")
    public Booking cancelBookedEvent(@PathVariable int bookingId)
    {
        return bookingService.cancelBookedEvent(bookingId, "CANCELLED");
    }
}
