package com.geop.AtualizacoesGerais.api.services.inteligenciaAnaliticaService;


import com.geop.AtualizacoesGerais.api.dtos.inteligenciaAnaliticaDto.InteligenciaAnaliticaRequest;
import com.geop.AtualizacoesGerais.api.dtos.inteligenciaAnaliticaDto.InteligenciaAnaliticaResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InteligenciaAnaliticaService {
    List<InteligenciaAnaliticaResponse>findInteligenciaList();
    Optional<InteligenciaAnaliticaResponse> findInteligenciaId(UUID uuid);
    void createInteligencia(InteligenciaAnaliticaRequest inteligenciaAnaliticaRequest);
    void updateInteligencia(UUID uuid,InteligenciaAnaliticaRequest inteligenciaAnaliticaRequest);
    void deleteInteligencia(UUID uuid);

}
