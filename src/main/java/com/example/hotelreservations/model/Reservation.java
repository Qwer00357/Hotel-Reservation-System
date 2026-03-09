package com.example.hotelreservations.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Entity representing a reservation.
 * Each reservation links a guest to a room for specific dates.
 * */

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique reservation ID

    @ManyToOne
    private Guest guest; // Linked guest

    @ManyToOne
    private Room room; // Linked room

    private LocalDate startDate; // Check-in date
    private LocalDate endDate; // Check-out date

    @Enumerated(EnumType.STRING)
    private ReservationStatus status; // Reservation status

    public Reservation(){}

    public Reservation(Guest guest, Room room, LocalDate startDate, LocalDate endDate, ReservationStatus status){
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
