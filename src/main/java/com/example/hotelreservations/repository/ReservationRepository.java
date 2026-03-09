package com.example.hotelreservations.repository;

import com.example.hotelreservations.model.Reservation;
import com.example.hotelreservations.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for reservation.
 * */

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRoomAndEndDateAfterAndStartDateBefore(Room room, LocalDate start, LocalDate end);
}
