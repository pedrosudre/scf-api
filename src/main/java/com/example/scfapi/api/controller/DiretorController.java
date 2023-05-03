package com.example.scfapi.api.controller;

import com.example.scfapi.api.dto.DiretorDTO;
import com.example.scfapi.exception.RegraNegocioException;
import com.example.scfapi.model.entity.Diretor;
import com.example.scfapi.service.DiretorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/diretores")
@RequiredArgsConstructor
public class DiretorController {

    private final DiretorService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Diretor> diretores = service.getDiretores();
        return ResponseEntity.ok(diretores.stream().map(DiretorDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Diretor> diretor = service.getDiretorById(id);
        if (!diretor.isPresent()) {
            return new ResponseEntity("Diretor não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(diretor.map(DiretorDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(DiretorDTO dto) {
        try {
            Diretor diretor = converter(dto);
            diretor = service.salvar(diretor);
            return new ResponseEntity(diretor, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public Diretor converter(DiretorDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Diretor diretor = modelMapper.map(dto, Diretor.class);

        return diretor;
    }

}

