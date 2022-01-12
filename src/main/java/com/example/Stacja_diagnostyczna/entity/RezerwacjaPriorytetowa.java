package com.example.Stacja_diagnostyczna.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RezerwacjaPriorytetowa {

    @Id
    @NotNull
    private int IdRezPio;

    @NotNull
    private String DodatkowaOplata;

    @NotNull
    private String minCzasOczekiwania;

    @NotNull
    @OneToOne
    private Rezerwacj rezerwacj;
}
