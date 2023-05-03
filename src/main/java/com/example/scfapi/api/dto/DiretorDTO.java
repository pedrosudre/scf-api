package com.example.scfapi.api.dto;

import com.example.scfapi.model.entity.Diretor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

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

    public static DiretorDTO create(Diretor diretor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(diretor, DiretorDTO.class);
    }
}
