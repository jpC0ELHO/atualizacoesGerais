package com.geop.AtualizacoesGerais.domain.repositories;

import com.geop.AtualizacoesGerais.domain.entities.InteligenciaAnalitica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InteligenciaAnaliticaRepository extends JpaRepository<InteligenciaAnalitica, UUID> {
    Optional<InteligenciaAnalitica>findById(UUID uuid);
}
