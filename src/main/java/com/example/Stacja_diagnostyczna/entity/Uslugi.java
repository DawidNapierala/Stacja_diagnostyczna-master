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
public class Uslugi {


    @Id
    @NotNull
    private int IdUslugi;

    @NotNull
    private String rodzajUslugi;
    @NotNull
    private String koszt;
    @NotNull
    private String szaczowanyCzas;


}
