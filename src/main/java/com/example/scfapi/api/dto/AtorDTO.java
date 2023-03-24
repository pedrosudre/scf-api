package com.example.scfapi.api.dto;

import com.example.scfapi.model.entity.Ator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AtorDTO {
    private Long id;
    private String nome;
    private String filme;
    private String nacionalidade;
    private String dataNascimento;
    private String personagem;


}
