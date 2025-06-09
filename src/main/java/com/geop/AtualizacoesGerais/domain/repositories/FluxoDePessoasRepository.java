package com.geop.AtualizacoesGerais.domain.repositories;

import com.geop.AtualizacoesGerais.domain.entities.FluxoDePessoas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FluxoDePessoasRepository extends JpaRepository<FluxoDePessoas, UUID> {
    Optional<FluxoDePessoas>findById(UUID uuid);
}
