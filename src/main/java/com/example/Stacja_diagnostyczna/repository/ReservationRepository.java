package com.example.Stacja_diagnostyczna.repository;

import com.example.Stacja_diagnostyczna.entity.Reservation;
import com.example.Stacja_diagnostyczna.entity.Serwis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public List<Reservation> findAllByIdNotIn(List<Long> ids);
}
