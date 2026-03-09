package com.example.hotelreservations.repository;

import com.example.hotelreservations.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for room.
 * */

public interface RoomRepository extends JpaRepository<Room, Long> {
}
