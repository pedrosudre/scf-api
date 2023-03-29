package com.example.scfapi.model.repository;

import com.example.scfapi.model.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
