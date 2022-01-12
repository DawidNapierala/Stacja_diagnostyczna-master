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
public class RezerwacjaZwykla {

    @Id
    @NotNull
    private int IdRezZwy;

    @NotNull
    private String minCzasOczekiwania;

    @NotNull
    @OneToOne
    private Rezerwacj rezerwacj;
}
