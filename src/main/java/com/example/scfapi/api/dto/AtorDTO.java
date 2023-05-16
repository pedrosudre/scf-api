package com.example.scfapi.api.dto;

import com.example.scfapi.model.entity.Ator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AtorDTO {
    private Long id;
    private String qtdeOscar;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;

    public static AtorDTO create(Ator ator) {
        ModelMapper modelMapper = new ModelMapper();
        AtorDTO dto = modelMapper.map(ator, AtorDTO.class);
        return dto;
    }

}
