package com.example.scfapi.api.dto;

import com.example.scfapi.model.entity.Ator;
import com.example.scfapi.model.entity.Filme;
import com.example.scfapi.model.entity.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FilmeDTO {
    private Long id;
    private String nome;
    private int nota;
    private Long idGenero;

    public static AtorDTO create(Filme filme) {
        ModelMapper modelMapper = new ModelMapper();
        AtorDTO dto = modelMapper.map(filme, AtorDTO.class);
        return dto;
    }
}
