package com.example.hotelreservations.repository;

import com.example.hotelreservations.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Guest entity.
 * */

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
