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

    private AtorRepository atorRepository;

    public AtorService(AtorRepository repository) {
        this.atorRepository = repository;
    }

    public List<Ator> getAtores() {
        return atorRepository.findAll();
    }

    public Optional<Ator> getAtorById(Long id) {
        return atorRepository.findById(id);
    }

    @Transactional
    public Ator salvar(Ator ator) {
        return this.atorRepository.save(ator);
    }

    @Transactional
    public void excluir(Ator ator) {
        Objects.requireNonNull(ator.getId());
        atorRepository.delete(ator);
    }

   /* public void validar(Ator ator) {
        if (ator.getNome() == null || ator.getNome().trim().equals("")) {
            throw new RegraNegocioException("Nome inválido");
        }
    }*/
}
