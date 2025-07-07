package com.geop.AtualizacoesGerais.api.services.fluxoDePessoasService;

import com.geop.AtualizacoesGerais.api.dtos.fluxoDePessoasDto.FluxoDePessoasRequest;
import com.geop.AtualizacoesGerais.api.dtos.fluxoDePessoasDto.FluxoDePessoasResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface FluxoDePessoasService {
    //criar os request de estacionamento dia mes e anos.
    List<FluxoDePessoasResponse>findFluxoDePessoasList();
    Optional<FluxoDePessoasResponse>findFluxoDePessoasId(UUID uuid);
    void createFluxoDePessoas(FluxoDePessoasRequest fluxoDePessoasRequest);
    void updateFluxoDePessoas(UUID uuid,FluxoDePessoasRequest fluxoDePessoasRequest);
    void deleteFluxoDePessoas(UUID uuid);
}
