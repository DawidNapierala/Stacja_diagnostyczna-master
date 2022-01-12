package com.example.Stacja_diagnostyczna.repository;

import com.example.Stacja_diagnostyczna.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
