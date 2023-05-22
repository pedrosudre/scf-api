package com.example.scfapi.api.controller;

import com.example.scfapi.api.dto.GeneroDTO;
import com.example.scfapi.exception.RegraNegocioException;
import com.example.scfapi.model.entity.Genero;
import com.example.scfapi.service.GeneroService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/generos")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Genero> generos = service.getGeneros();
        return ResponseEntity.ok(generos.stream().map(GeneroDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Genero> genero = service.getGeneroById(id);
        if (!genero.isPresent()) {
            return new ResponseEntity("Aluno não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(genero.map(GeneroDTO::create));
    }


    @PostMapping("")
    public ResponseEntity Post(@RequestBody GeneroDTO generoDTO) {
        try {
            Genero genero = converter(generoDTO); // Aplicando tratando do DTO
            genero = service.salvar(genero);
            return new ResponseEntity(genero, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable("id") final Long id, @RequestBody GeneroDTO dto) {
        if (!service.getGeneroById(id).isPresent()) {
            return new ResponseEntity("Genero não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            Genero genero = converter(dto);
            genero.setId(id);
            service.salvar(genero);
            return ResponseEntity.ok(genero);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        Optional<Genero> genero = service.getGeneroById(id);
        if (!genero.isPresent()) {
            return new ResponseEntity("Genero não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            service.excluir(genero.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    public Genero converter(GeneroDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Genero genero = modelMapper.map(dto, Genero.class);

        return genero;
    }
}
