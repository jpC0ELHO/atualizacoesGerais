package com.geop.AtualizacoesGerais.api.dtos.inteligenciaAnaliticaDto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.geop.AtualizacoesGerais.domain.entities.InteligenciaAnalitica;
import com.geop.AtualizacoesGerais.domain.exceptions.NullableException;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({"uuid", "previsao_de_fluxo_futuro", "previsao_ocupacao_estimada", "previsao_eventos_irregulares",
        "agregacao_temporal", "media_movel", "desvio_padrao", "variancia", "tendencia_de_crescimento",
        "correlacao_fluxo_ocupacao", "correlacao_dia_hora_pico", "classificacao_setor_risco",
        "classificacao_nivel_utilizacao", "sugestao_operacional", "sugestao_estrategica",
        "periodo_inicio", "periodo_fim", "contexto_analise", "created_at", "updated_at"})
public record InteligenciaAnaliticaResponse(
        UUID uuid,
        BigDecimal previsaoDeFluxoFuturo,
        BigDecimal previsaoOcupacaoEstimada,
        Integer previsaoEventosIrregulares,
        BigDecimal agregacaoTemporal,
        BigDecimal mediaMovel,
        BigDecimal desvioPadrao,
        BigDecimal variancia,
        BigDecimal tendenciaDeCrescimento,
        BigDecimal correlacaoFluxoOcupacao,
        BigDecimal correlacaoDiaHoraPico,
        String classificacaoSetorRisco,
        String classificacaoNivelUtilizacao,
        String sugestaoOperacional,
        String sugestaoEstrategica,
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
        LocalDateTime periodoInicio,
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
        LocalDateTime periodoFim,
        String contextoAnalise,
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
        LocalDateTime createdAt,
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
        LocalDateTime updatedAt
) {
    public static InteligenciaAnaliticaResponse toResponse(InteligenciaAnalitica inteligenciaAnalitica){
        if (inteligenciaAnalitica==null){
            throw new NullableException("Resposta nula!");
        }
        return new InteligenciaAnaliticaResponse(
                inteligenciaAnalitica.getUuid(),
                inteligenciaAnalitica.getPrevisaoDeFluxoFuturo(),
                inteligenciaAnalitica.getPrevisaoOcupacaoEstimada(),
                inteligenciaAnalitica.getPrevisaoEventosIrregulares(),
                inteligenciaAnalitica.getAgregacaoTemporal(),
                inteligenciaAnalitica.getMediaMovel(),
                inteligenciaAnalitica.getDesvioPadrao(),
                inteligenciaAnalitica.getVariancia(),
                inteligenciaAnalitica.getTendenciaDeCrescimento(),
                inteligenciaAnalitica.getCorrelacaoFluxoOcupacao(),
                inteligenciaAnalitica.getCorrelacaoDiaHoraPico(),
                inteligenciaAnalitica.getClassificacaoSetorRisco(),
                inteligenciaAnalitica.getClassificacaoNivelUtilizacao(),
                inteligenciaAnalitica.getSugestaoOperacional(),
                inteligenciaAnalitica.getSugestaoEstrategica(),
                inteligenciaAnalitica.getPeriodoInicio(),
                inteligenciaAnalitica.getPeriodoFim(),
                inteligenciaAnalitica.getContextoAnalise(),
                inteligenciaAnalitica.getCreatedAt(),
                inteligenciaAnalitica.getUpdatedAt()
        );
    }
}
