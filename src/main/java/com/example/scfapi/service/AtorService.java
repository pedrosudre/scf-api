package com.example.scfapi.service;

import com.example.scfapi.exception.RegraNegocioException;
import com.example.scfapi.model.entity.Ator;
import com.example.scfapi.model.repository.AtorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AtorService {

    private AtorRepository repository;

    public AtorService(AtorRepository repository) {
        this.repository = repository;
    }

    public List<Ator> getAtores() {
        return repository.findAll();
    }

    public Optional<Ator> getAtorById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Ator salvar(Ator ator) {
        validar(ator);
        return repository.save(ator);
    }

    @Transactional
    public void excluir(Ator ator) {
        Objects.requireNonNull(ator.getId());
        repository.delete(ator);
    }

    public void validar(Ator ator) {
        if (ator.getFilme() == null || ator.getFilme().trim().equals("")) {
            throw new RegraNegocioException("Filme inválido.");
        }
    }
}
