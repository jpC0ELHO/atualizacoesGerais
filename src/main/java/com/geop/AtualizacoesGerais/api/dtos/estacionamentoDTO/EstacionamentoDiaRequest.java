package com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.geop.AtualizacoesGerais.domain.entities.EstacionamentoDiaDados;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record EstacionamentoDiaRequest(
         Boolean ocupada,
         Integer tempoOcupacaoAtual,
         Integer quantidadeTrocasDia,
         Integer vagasOcupadas,
         Integer vagasLivres,
         String horarioPico,
         Integer tempoTotalLivre,
         Boolean vagasSubutilizadas,
         Boolean vagasCriticas,
         LocalDateTime dataHoraEvento
) {
    public static EstacionamentoDiaDados toEntidade(EstacionamentoDiaRequest estacionamentoDiaRequest){
        if (estacionamentoDiaRequest==null){
            return null;
        }
        return new EstacionamentoDiaDados(
                estacionamentoDiaRequest.ocupada,
                estacionamentoDiaRequest.tempoOcupacaoAtual,
                estacionamentoDiaRequest.quantidadeTrocasDia,
                estacionamentoDiaRequest.vagasOcupadas,
                estacionamentoDiaRequest.vagasLivres,
                estacionamentoDiaRequest.horarioPico,
                estacionamentoDiaRequest.tempoTotalLivre,
                estacionamentoDiaRequest.vagasSubutilizadas,
                estacionamentoDiaRequest.vagasCriticas,
                estacionamentoDiaRequest.dataHoraEvento
        );
    }
}
