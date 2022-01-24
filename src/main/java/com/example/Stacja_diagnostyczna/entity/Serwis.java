package com.example.Stacja_diagnostyczna.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Serwis {

    @Id
    @GeneratedValue
    private Long id;

    public String ServiceName;
    public float ServicePrice;
}
