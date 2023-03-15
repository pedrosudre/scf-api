package com.example.scfapi.api.dto;

import com.example.scfapi.model.entity.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FilmeDTO {
    private Long id;
    private String nome;
    private Integer relevancia;
    private Genero genero;
}
