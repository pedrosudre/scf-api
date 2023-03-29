package com.example.scfapi.service;

import com.example.scfapi.exception.RegraNegocioException;
import com.example.scfapi.model.entity.Ator;
import com.example.scfapi.model.entity.Filme;
import com.example.scfapi.model.repository.AtorRepository;
import com.example.scfapi.model.repository.FilmeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FilmeService {

    private FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public List<Filme> getFilmes() {
        return repository.findAll();
    }

    public Optional<Filme> getFilmeById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Filme salvar(Filme filme) {
        validar(filme);
        return repository.save(filme);
    }

    @Transactional
    public void excluir(Filme filme) {
        Objects.requireNonNull(filme.getId());
        repository.delete(filme);
    }

    public void validar(Filme filme) {
        if (filme.getNome() == null || filme.getNome().trim().equals("")) {
            throw new RegraNegocioException("Nome inválido");
        }
    }
}
