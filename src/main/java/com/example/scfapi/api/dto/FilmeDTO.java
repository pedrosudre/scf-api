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
    private String nomeGenero;
    private Long idDiretor;
    private String nomeDiretor;
    private Long idAtor;
    private String nomeAtor;

    public static FilmeDTO create(Filme filme) {
        ModelMapper modelMapper = new ModelMapper();
        FilmeDTO dto = modelMapper.map(filme, FilmeDTO.class);
        dto.nomeAtor = filme.getAtor().getNome();
        dto.nomeDiretor = filme.getDiretor().getNome();
        dto.nomeGenero = filme.getGenero().getNome();
        return dto;
    }
}
