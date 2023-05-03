package com.example.scfapi.api.dto;

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
    private Integer relevancia;
    private Genero genero;

    public static FilmeDTO create(Filme filme) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(filme, FilmeDTO.class);
    }
}
