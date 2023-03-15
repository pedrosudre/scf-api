package com.example.scfapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DiretorDTO {
    private Long id;
    private String nome;
    private String filme;
    private String nacionalidade;
    private String dataNascimento;
    private String qtdePremios;
}
