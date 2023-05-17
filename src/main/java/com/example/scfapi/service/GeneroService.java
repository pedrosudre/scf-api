package com.example.scfapi.service;

import com.example.scfapi.model.entity.Ator;
import com.example.scfapi.model.entity.Genero;
import com.example.scfapi.model.repository.GeneroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GeneroService {

    private GeneroRepository generoRepository;

    public GeneroService(GeneroRepository repository) {
        this.generoRepository = repository;
    }

    public List<Genero> getGeneros() {
        return generoRepository.findAll();
    }

    public Optional<Genero> getGeneroById(Long id) {
        return generoRepository.findById(id);
    }

    @Transactional
    public Genero salvar(Genero genero) {
        return generoRepository.save(genero);
    }

    @Transactional
    public void excluir(Genero genero) {
        Objects.requireNonNull(genero.getId());
        generoRepository.delete(genero);
    }


}
