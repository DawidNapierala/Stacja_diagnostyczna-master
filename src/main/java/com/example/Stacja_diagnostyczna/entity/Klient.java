package com.example.Stacja_diagnostyczna.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Klient {

    @Id
    @NotNull
    private int IdKlienta;

    @NotNull
    private String Imie;

    @NotNull
    private String Nazwisko;

    @NotNull
    private String NumerTelefonu;

    @NotNull
    private String NumerEmail;

    @NotNull
    private String Auto;

    @NotNull
    @ManyToOne
    private Diagnosta diagnosta;

}
