package com.geop.AtualizacoesGerais.api.dtos.fluxoDePessoasDto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.geop.AtualizacoesGerais.domain.entities.FluxoDePessoas;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record FluxoDePessoasRequest(
        @NotNull
        Integer quantidadeAcessoHorario,
        @NotNull
        Integer quantidadeAcessoDia,
        @NotNull
        Integer quantidadeAcessoMes,
        @NotNull
        Integer quantidadeAcessoAno,
        @NotNull
        Integer quantidadeAcessoAnos,
        @NotNull
        Integer valorAferido,
        @NotNull
        Integer valorTotal,
        @NotNull
        Integer valorMedio,
        @NotNull
        Integer valorDivisao,
        @NotNull
        Integer valorSoma,
        @NotNull
        Integer tempoMedioPermanencia
) {
    public static FluxoDePessoas toEntidade(FluxoDePessoasRequest fluxoDePessoasRequest){
        if (fluxoDePessoasRequest==null){
            return null;
        }
        return new FluxoDePessoas(
                fluxoDePessoasRequest.quantidadeAcessoHorario,
                fluxoDePessoasRequest.quantidadeAcessoDia,
                fluxoDePessoasRequest.quantidadeAcessoMes,
                fluxoDePessoasRequest.quantidadeAcessoAno,
                fluxoDePessoasRequest.quantidadeAcessoAnos,
                fluxoDePessoasRequest.valorAferido,
                fluxoDePessoasRequest.valorTotal,
                fluxoDePessoasRequest.valorMedio,
                fluxoDePessoasRequest.valorDivisao,
                fluxoDePessoasRequest.valorSoma,
                fluxoDePessoasRequest.tempoMedioPermanencia
        );
    }
}
