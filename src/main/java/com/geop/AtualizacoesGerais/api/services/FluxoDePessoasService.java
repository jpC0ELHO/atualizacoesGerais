package com.geop.AtualizacoesGerais.api.services;

import com.geop.AtualizacoesGerais.api.dtos.FluxoDePessoasRequest;
import com.geop.AtualizacoesGerais.api.dtos.FluxoDePessoasResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FluxoDePessoasService {
    List<FluxoDePessoasResponse>findFluxoDePessoasList();
    Optional<FluxoDePessoasResponse>findFluxoDePessoasId(UUID uuid);
    void createFluxoDePessoas(FluxoDePessoasRequest fluxoDePessoasRequest);
    void updateFluxoDePessoas(UUID uuid,FluxoDePessoasRequest fluxoDePessoasRequest);
    void deleteFluxoDePessoas(UUID uuid);
}
