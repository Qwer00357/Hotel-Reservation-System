package com.example.hotelreservations.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object for creating reservations.
 * Used to separate API request payload by entity.
 * */

public class ReservationRequest {

    private Long guestId; // ID of the guest making the reservation
    private Long roomId; // ID of the room to book
    private LocalDate startDate; // Check-in date
    private LocalDate endDate; // Check-out date

    public Long getGuestId(){return guestId;}
    public Long getRoomId(){return roomId;}

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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
}
