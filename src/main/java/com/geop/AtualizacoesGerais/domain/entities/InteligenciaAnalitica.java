package com.geop.AtualizacoesGerais.domain.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inteligencia_analitica")
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InteligenciaAnalitica extends Entidade {

    // Previsões
    @Column(name = "previsao_fluxo_futuro")
    private BigDecimal previsaoDeFluxoFuturo;

    @Column(name = "previsao_ocupacao_estimada")
    private BigDecimal previsaoOcupacaoEstimada;

    @Column(name = "previsao_eventos_irregulares")
    private Integer previsaoEventosIrregulares;

    // Agregações
    @Column(name = "agregacao_temporal")
    private BigDecimal agregacaoTemporal;

    @Column(name = "media_movel")
    private BigDecimal mediaMovel;

    @Column(name = "desvio_padrao")
    private BigDecimal desvioPadrao;

    @Column(name = "variancia")
    private BigDecimal variancia;

    @Column(name = "tendencia_de_crescimento")
    private BigDecimal tendenciaDeCrescimento;

    // Correlações
    @Column(name = "correlacao_fluxo_ocupacao")
    private BigDecimal correlacaoFluxoOcupacao;

    @Column(name = "correlacao_dia_hora_pico")
    private BigDecimal correlacaoDiaHoraPico;

    // Classificações
    @Column(name = "classificacao_setor_risco")
    private String classificacaoSetorRisco;

    @Column(name = "classificacao_nivel_utilizacao")
    private String classificacaoNivelUtilizacao;

    // Insights e sugestões
    @Column(name = "sugestao_operacional")
    private String sugestaoOperacional;

    @Column(name = "sugestao_estrategica")
    private String sugestaoEstrategica;

    // Período de análise
    @Column(name = "periodo_inicio")
    private LocalDateTime periodoInicio;

    @Column(name = "periodo_fim")
    private LocalDateTime periodoFim;

    // Setor ou contexto alvo
    @Column(name = "contexto_analise")
    private String contextoAnalise; // Ex: "Estacionamento", "Portaria", etc.
}