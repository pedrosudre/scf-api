package com.example.scfapi.api.dto;

import com.example.scfapi.model.entity.Diretor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DiretorDTO {
    private Long id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;
    private String qtdeFilme;

    public static DiretorDTO create(Diretor diretor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(diretor, DiretorDTO.class);
    }
}
