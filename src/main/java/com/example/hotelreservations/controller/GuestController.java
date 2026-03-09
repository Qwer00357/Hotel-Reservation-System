package com.example.hotelreservations.controller;

import com.example.hotelreservations.model.Guest;
import com.example.hotelreservations.repository.GuestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing guest
 * Provides CRUD operations for Guest entity.
 * */

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }

    /**
     * Get all guests.
     * */
    @GetMapping
    public List<Guest> getAllGuests(){
        return guestRepository.findAll();
    }

    /**
     * Create guest.
     * */
    @PostMapping
    public Guest createGuest(@RequestBody Guest guest){
        return guestRepository.save(guest);
    }

    /**
     * Get guest by ID.
     * */
    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable Long id){
        return guestRepository.findById(id).orElseThrow(()->new RuntimeException("Guest not found"));
    }

    /**
     * Delete guest by id.
     * */
    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id){
        guestRepository.deleteById(id);
    }
}
