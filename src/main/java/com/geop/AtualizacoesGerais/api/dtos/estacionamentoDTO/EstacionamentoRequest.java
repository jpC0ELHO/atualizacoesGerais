package com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO;

import com.geop.AtualizacoesGerais.domain.entities.Estacionamento;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EstacionamentoRequest(
        String idVaga,
        @NotNull
        String localizacao,
        @NotNull
        String tipoVaga,
        String sensorId,
        String cameraId,
        String placaVeiculo,
        @NotNull
        Boolean ocupada,
        Integer tempoOcupacaoAtual,
        Integer quantidadeTrocasDia,
        Integer vagasOcupadas,
        Integer vagasLivres,
        String horarioPico,
        Integer tempoTotalLivre,
        Boolean vagasSubutilizadas,
        Boolean vagasCriticas,
        Double taxaRotatividade,
        Double taxaOcupacao,
        String diaMaiorMovimento,
        Integer mediaDiariaEntradaVeiculos,
        String previsaoFluxoProximoHorario,
        Integer totalVagas,
        String eventoIrregularDetectado,
        LocalDateTime dataHoraEvento,
        Double percentualUsoPorVaga,
        Integer tempoMedioOcupacao,
        Integer horarioDePicoMedia,
        LocalDateTime dataUltimaAtualizacao,
        String usuarioResponsavel
) {
    public static Estacionamento toEntidade(EstacionamentoRequest estacionamentoRequest){
        if (estacionamentoRequest==null){
            return null;
        }
        return new Estacionamento(
                estacionamentoRequest.idVaga(),
                estacionamentoRequest.localizacao(),
                estacionamentoRequest.tipoVaga(),
                estacionamentoRequest.sensorId(),
                estacionamentoRequest.cameraId(),
                estacionamentoRequest.placaVeiculo(),
                estacionamentoRequest.ocupada(),
                estacionamentoRequest.tempoOcupacaoAtual(),
                estacionamentoRequest.quantidadeTrocasDia(),
                estacionamentoRequest.vagasOcupadas(),
                estacionamentoRequest.vagasLivres(),
                estacionamentoRequest.horarioPico(),
                estacionamentoRequest.tempoTotalLivre(),
                estacionamentoRequest.vagasSubutilizadas(),
                estacionamentoRequest.vagasCriticas(),
                estacionamentoRequest.taxaRotatividade(),
                estacionamentoRequest.taxaOcupacao(),
                estacionamentoRequest.diaMaiorMovimento(),
                estacionamentoRequest.mediaDiariaEntradaVeiculos(),
                estacionamentoRequest.previsaoFluxoProximoHorario(),
                estacionamentoRequest.totalVagas(),
                estacionamentoRequest.eventoIrregularDetectado(),
                estacionamentoRequest.dataHoraEvento(),
                estacionamentoRequest.percentualUsoPorVaga(),
                estacionamentoRequest.tempoMedioOcupacao(),
                estacionamentoRequest.horarioDePicoMedia(),
                estacionamentoRequest.dataUltimaAtualizacao(),
                estacionamentoRequest.usuarioResponsavel()
        );
    }
}
