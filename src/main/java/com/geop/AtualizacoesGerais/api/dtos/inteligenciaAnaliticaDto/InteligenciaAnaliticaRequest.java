package com.geop.AtualizacoesGerais.api.dtos.inteligenciaAnaliticaDto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.geop.AtualizacoesGerais.domain.entities.InteligenciaAnalitica;
import com.geop.AtualizacoesGerais.domain.exceptions.NullableException;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record InteligenciaAnaliticaRequest(
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
        LocalDateTime periodoInicio,
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime periodoFim,
        String contextoAnalise
) {
    public static InteligenciaAnalitica toEntidade(InteligenciaAnaliticaRequest inteligenciaAnaliticaRequest){
        if (inteligenciaAnaliticaRequest==null){
            throw new NullableException("A requisição está nula!");
        }
        return new InteligenciaAnalitica(
                inteligenciaAnaliticaRequest.previsaoDeFluxoFuturo(),
                inteligenciaAnaliticaRequest.previsaoOcupacaoEstimada(),
                inteligenciaAnaliticaRequest.previsaoEventosIrregulares(),
                inteligenciaAnaliticaRequest.agregacaoTemporal(),
                inteligenciaAnaliticaRequest.mediaMovel(),
                inteligenciaAnaliticaRequest.desvioPadrao(),
                inteligenciaAnaliticaRequest.variancia(),
                inteligenciaAnaliticaRequest.tendenciaDeCrescimento(),
                inteligenciaAnaliticaRequest.correlacaoFluxoOcupacao(),
                inteligenciaAnaliticaRequest.correlacaoDiaHoraPico(),
                inteligenciaAnaliticaRequest.classificacaoSetorRisco(),
                inteligenciaAnaliticaRequest.classificacaoNivelUtilizacao(),
                inteligenciaAnaliticaRequest.sugestaoOperacional(),
                inteligenciaAnaliticaRequest.sugestaoEstrategica(),
                inteligenciaAnaliticaRequest.periodoInicio(),
                inteligenciaAnaliticaRequest.periodoFim(),
                inteligenciaAnaliticaRequest.contextoAnalise()
        );
    }
}
