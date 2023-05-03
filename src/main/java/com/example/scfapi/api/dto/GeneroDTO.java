package com.example.scfapi.api.dto;


import com.example.scfapi.model.entity.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GeneroDTO {
    private Long id;
    private String nome;

    public static GeneroDTO create(Genero genero) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(genero, GeneroDTO.class);
    }
}
