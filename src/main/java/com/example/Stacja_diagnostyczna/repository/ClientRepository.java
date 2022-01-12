package com.example.Stacja_diagnostyczna.repository;

import com.example.Stacja_diagnostyczna.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
