package com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO;

import com.geop.AtualizacoesGerais.domain.entities.Estacionamento;

public record EstacionamentoMesRequest(
        Double taxaRotatividade,
        Double taxaOcupacao,
        String diaMaiorMovimento,
        Integer mediaDiariaEntradaVeiculos
) {
    public static Estacionamento toEntidade(EstacionamentoRequest estacionamentoRequest){
        if (estacionamentoRequest==null){
            return null;
        }
        return new Estacionamento(

        );
    }
}
