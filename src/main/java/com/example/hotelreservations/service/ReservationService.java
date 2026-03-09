package com.example.hotelreservations.service;

import com.example.hotelreservations.model.Guest;
import com.example.hotelreservations.model.Reservation;
import com.example.hotelreservations.model.ReservationStatus;
import com.example.hotelreservations.model.Room;
import com.example.hotelreservations.repository.ReservationRepository;
import com.example.hotelreservations.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Service class for managing reservations.
 * Handles logic like creating reservation and preventing double booking.
 * */

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository){
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }
    /**
     * Create a new reservation.
     * Checks if the room is available for the given dates.
     * */
    public Reservation createReservation(Guest guest, Room room, LocalDate start, LocalDate end){
        if(end.isBefore(start) || start.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Invalid reservation dates");
        }
        List<Reservation> existing = reservationRepository.findByRoomAndEndDateAfterAndStartDateBefore(room, start, end);
        if(!existing.isEmpty()){
            throw new IllegalArgumentException("Room is already booked for this period");
        }
        Reservation reservation = new Reservation(guest, room, start, end, ReservationStatus.CONFIRMED);
        return reservationRepository.save(reservation);
    }
    /**
     * Get all reservations
     * */
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
