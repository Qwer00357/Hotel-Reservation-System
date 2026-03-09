package com.example.hotelreservations.controller;

import com.example.hotelreservations.model.Room;
import com.example.hotelreservations.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * REST controller for managing hotel rooms.
 * */

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    /**
     * Get all rooms.
     * */
    @GetMapping
    public List<Room> getRooms(){
        return roomService.getAllRooms();
    }

    /**
     * Add a new room.
     * */
    @PostMapping
    public Room createRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }

    @GetMapping("/available")
    public List<Room> getAvaliableRooms(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return roomService.getAvaliableRooms(startDate, endDate);
    }
}
