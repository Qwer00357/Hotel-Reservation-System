package com.example.hotelreservations.service;

import com.example.hotelreservations.model.Room;
import com.example.hotelreservations.repository.ReservationRepository;
import com.example.hotelreservations.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Service class for managing hotel rooms.
 * Handles logic related to rooms like creating room or getting all/available rooms.
 * */

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public RoomService(RoomRepository roomRepository, ReservationRepository reservationRepository){
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    /**
     * Get all rooms.
     * */
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    /**
     * Create a new room.
     * */
    public Room createRoom(Room room){
        return roomRepository.save(room);
    }

    /**
     * Get all available rooms.
     * */
    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate){
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().filter(room->reservationRepository.findByRoomAndEndDateAfterAndStartDateBefore(room, startDate, endDate).isEmpty()).toList();
    }
}
