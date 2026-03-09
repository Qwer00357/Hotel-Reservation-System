package com.example.hotelreservations.controller;

import com.example.hotelreservations.dto.ReservationRequest;
import com.example.hotelreservations.model.Guest;
import com.example.hotelreservations.model.Reservation;
import com.example.hotelreservations.model.Room;
import com.example.hotelreservations.repository.GuestRepository;
import com.example.hotelreservations.repository.RoomRepository;
import com.example.hotelreservations.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Reservation endpoints.
 * Maps HTTP request to ReservationService methods.
 * */

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public ReservationController(ReservationService reservationService,
                                 GuestRepository guestRepository,
                                 RoomRepository roomRepository) {
        this.reservationService = reservationService;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }
    /**
     * Create a new reservation.
     * */
    @PostMapping
    public Reservation createReservation(@RequestBody ReservationRequest request){
        Guest guest = guestRepository.findById(request.getGuestId()).orElseThrow(()->new IllegalArgumentException("Guest not found"));
        Room room = roomRepository.findById(request.getRoomId()).orElseThrow(()->new IllegalArgumentException("Room not found"));
        return reservationService.createReservation(guest, room, request.getStartDate(), request.getEndDate());
    }
    /**
     * Get all reservations.
     * */
    @GetMapping
    public List<Reservation> getReservations(){
        return reservationService.getAllReservations();
    }
}
