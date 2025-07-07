package com.geop.AtualizacoesGerais.api.services.estacionamentoService;

import com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstacionamentoService {
    List<EstacionamentoResponse>findEstacionamentoList();
    Optional<EstacionamentoResponse>findEstacionamentoId(UUID uuid);
    List<EstacionamentoDiaResponse>findEstacionamentoDia(EstacionamentoDiaResponse estacionamentoDiaResponse);
    List<EstacionamentoMesResponse>findEstacionamentoMes(EstacionamentoMesResponse estacionamentoMesResponse);
    List<EstacionamentoAnoResponse>findEstacionamentoAno(EstacionamentoAnoResponse estacionamentoAnoResponse);
    void createEstacionamento(EstacionamentoRequest estacionamentoRequest);
    void updateEstacionamento(UUID uuid,EstacionamentoRequest estacionamentoRequest);
    void deleteEstacionamento(UUID uuid);

}
