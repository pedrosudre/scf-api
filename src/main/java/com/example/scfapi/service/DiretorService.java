package com.example.scfapi.service;

import com.example.scfapi.exception.RegraNegocioException;
import com.example.scfapi.model.entity.Ator;
import com.example.scfapi.model.entity.Diretor;
import com.example.scfapi.model.repository.AtorRepository;
import com.example.scfapi.model.repository.DiretorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DiretorService {

    private DiretorRepository repository;


    public DiretorService(DiretorRepository repository) {
        this.repository = repository;
    }

    public List<Diretor> getDiretores() {
        return repository.findAll();
    }

    public Optional<Diretor> getDiretorById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Diretor salvar(Diretor diretor) {
        validar(diretor);
        return repository.save(diretor);
    }

    @Transactional
    public void excluir(Diretor diretor) {
        Objects.requireNonNull(diretor.getId());
        repository.delete(diretor);
    }

    public void validar(Diretor diretor) {
        if (diretor.getFilme() == null || diretor.getFilme().trim().equals("")) {
            throw new RegraNegocioException("Filme inválido.");
        }
    }
}
