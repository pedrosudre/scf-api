package com.example.scfapi.api.controller;

import com.example.scfapi.api.dto.DiretorDTO;
import com.example.scfapi.api.dto.FilmeDTO;
import com.example.scfapi.api.dto.GeneroDTO;
import com.example.scfapi.exception.RegraNegocioException;
import com.example.scfapi.model.entity.Ator;
import com.example.scfapi.model.entity.Diretor;
import com.example.scfapi.model.entity.Filme;
import com.example.scfapi.model.entity.Genero;
import com.example.scfapi.model.repository.DiretorRepository;
import com.example.scfapi.service.AtorService;
import com.example.scfapi.service.DiretorService;
import com.example.scfapi.service.FilmeService;
import com.example.scfapi.service.GeneroService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/filmes")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class FilmeController {

    @Autowired
    private DiretorRepository diretorRepository;

    private final FilmeService service;
    private final AtorService atorService;
    private final DiretorService diretorService;
    private final GeneroService generoService;

    @GetMapping()
    public ResponseEntity get() {
        List<Filme> filmes = service.getFilmes();
        return ResponseEntity.ok(filmes.stream().map(FilmeDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Filme> filme = service.getFilmeById(id);
        if (!filme.isPresent()) {
            return new ResponseEntity("Filme não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(filme.map(FilmeDTO::create));
    }


    @PostMapping("")
    public ResponseEntity Post(@RequestBody FilmeDTO filmeDTO) {
        try {
            Filme filme = converter(filmeDTO); // Aplicando tratando do DTO
            filme = service.salvar(filme);
            return new ResponseEntity(filme, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable("id") final Long id, @RequestBody FilmeDTO dto) {
        if (!service.getFilmeById(id).isPresent()) {
            return new ResponseEntity("Filme não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            Filme filme = converter(dto);
            filme.setId(id);
            service.salvar(filme);
            return ResponseEntity.ok(filme);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        Optional<Filme> filme = service.getFilmeById(id);
        if (!filme.isPresent()) {
            return new ResponseEntity("Filme não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            service.excluir(filme.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public Filme converter(FilmeDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Filme filme = modelMapper.map(dto, Filme.class);
        return filme;
    }
}


