package com.example.scfapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int nota;

    @ManyToOne
    private Ator ator;

    @ManyToOne
    private Diretor diretor;

    @ManyToOne
    private Genero genero;

}
