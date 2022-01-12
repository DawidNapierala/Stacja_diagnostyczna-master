package com.example.Stacja_diagnostyczna.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StacjaDiagnostyczna {

    @Id
    @NotNull
    private int IdStacji;

    @NotNull
    private String NazwaStacji;

    @NotNull
    private String Kontakt;

    @NotNull
    private boolean Status;

}
