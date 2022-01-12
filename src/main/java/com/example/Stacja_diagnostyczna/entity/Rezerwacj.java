package com.example.Stacja_diagnostyczna.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rezerwacj {

    @Id
    @NotNull
    private int IdRezerwacji;

    @NotNull
    private Date data;

    @NotNull
    private String statusWykonania;

    @NotNull
    private String typRezerwacji;

    @NotNull
    @ManyToOne
    private Diagnosta diagnosta;

    @NotNull
    @ManyToOne
    private StacjaDiagnostyczna stacjaDiagnostyczna;

    @NotNull
    @ManyToOne
    private Uslugi uslugi;

}
