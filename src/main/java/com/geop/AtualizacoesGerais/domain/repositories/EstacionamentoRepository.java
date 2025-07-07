package com.geop.AtualizacoesGerais.domain.repositories;

import com.geop.AtualizacoesGerais.domain.entities.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, UUID> {
    Optional<Estacionamento>findById(UUID uuid);
    Optional<Estacionamento>findByIdVaga(String idVaga);
    @Query("SELECT e FROM Estacionamento e WHERE DATE(e.dataHoraEvento) = CURRENT_DATE")
    List<Estacionamento> findAllByDataHoje();
    @Query("SELECT e FROM Estacionamento e WHERE DATE(e.dataHoraEvento) = CURRENT_DATE")
    List<Estacionamento> findAllByDataMes();
    @Query("SELECT e FROM Estacionamento e WHERE DATE(e.dataHoraEvento) = CURRENT_DATE")
    List<Estacionamento> findAllByDataAno();
}
