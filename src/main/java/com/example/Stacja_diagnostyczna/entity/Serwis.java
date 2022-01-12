package com.example.Stacja_diagnostyczna.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Serwis {

    @Id
    @GeneratedValue
    private Long id;

    public String ServiceName;
    public float ServicePrice;
}
