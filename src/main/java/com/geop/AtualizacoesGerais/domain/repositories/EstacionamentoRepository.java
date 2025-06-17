package com.geop.AtualizacoesGerais.domain.repositories;

import com.geop.AtualizacoesGerais.domain.entities.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EstacionamentoRepository extends JpaRepository<UUID, Estacionamento> {
    Optional<Estacionamento>findById(UUID uuid);
}
