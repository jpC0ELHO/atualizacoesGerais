package com.geop.AtualizacoesGerais.domain.repositories;

import com.geop.AtualizacoesGerais.domain.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, UUID> {
    Optional<Estacionamento>findById(UUID uuid);
    Optional<Estacionamento>findByIdVaga(String idVaga);

    @Query("SELECT e FROM estacionamento_semana_dados e WHERE DATE(e.dataHoraEvento) = CURRENT_DATE")
    List<EstacionamentoSemanaDados> findAllBySemana(LocalDateTime localDateTime);
    @Query("SELECT e FROM estacionamento_mes_dados e WHERE DATE(e.dataHoraEvento) = CURRENT_DATE")
    List<EstacionamentoMesDados> findAllByDataMes(LocalDateTime localDateTime);
    @Query("SELECT e FROM estacionamento_ano_dados e WHERE DATE(e.dataHoraEvento) = CURRENT_DATE")
    List<EstacionamentoAnoDados> findAllByDataAno(LocalDateTime localDateTime);
}
