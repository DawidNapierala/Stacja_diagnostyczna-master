package com.example.Stacja_diagnostyczna.repository;

import com.example.Stacja_diagnostyczna.entity.Serwis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ServiceRepository extends JpaRepository<Serwis, Long> {

    @Query("select r.service.id from Reservation r where r.date = ?1")
    public List<Long> getAllServicesBooked(LocalDate date);
    public List<Serwis> findAllByIdNotIn(List<Long> ids);
}
