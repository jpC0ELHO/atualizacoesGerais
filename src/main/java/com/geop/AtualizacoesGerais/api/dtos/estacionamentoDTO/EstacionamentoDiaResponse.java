package com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.geop.AtualizacoesGerais.domain.entities.Estacionamento;
import com.geop.AtualizacoesGerais.domain.entities.EstacionamentoDiaDados;
import com.geop.AtualizacoesGerais.domain.exceptions.NullableException;
import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({
        "uuid","ocupada","tempoOcupacaoAtual","quantidadeTrocasDia","vagasOcupadas","vagasLivres",
        "horarioPico","tempoTotalLivre","vagasSubutilizadas","vagasCriticas",
        "createdBy","lastModifiedBy","createdAt","updatedAt"
})
public record EstacionamentoDiaResponse(
         UUID uuid,
         Boolean ocupada,
         Integer tempoOcupacaoAtual,
         Integer quantidadeTrocasDia,
         Integer vagasOcupadas,
         Integer vagasLivres,
         String horarioPico,
         Integer tempoTotalLivre,
         Boolean vagasSubutilizadas,
         Boolean vagasCriticas,
         @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
         @JsonSerialize(using = LocalDateTimeSerializer.class)
         @JsonDeserialize(using = LocalDateTimeDeserializer.class)
         @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
         LocalDateTime dataHoraEvento,
         String createdBy,
         String lastModifiedBy,
         @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
         @JsonSerialize(using = LocalDateTimeSerializer.class)
         @JsonDeserialize(using = LocalDateTimeDeserializer.class)
         @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
         LocalDateTime createdAt,
         @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
         @JsonSerialize(using = LocalDateTimeSerializer.class)
         @JsonDeserialize(using = LocalDateTimeDeserializer.class)
         @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
         LocalDateTime updatedAt
) {
    public static EstacionamentoDiaResponse toResponse(EstacionamentoDiaDados estacionamentoDiaDados) {
        if (estacionamentoDiaDados == null) {
            throw new NullableException("Estacionamento não pode ser nulo.");
        }

        return new EstacionamentoDiaResponse(
                estacionamentoDiaDados.getUuid(),
                estacionamentoDiaDados.getOcupada(),
                estacionamentoDiaDados.getTempoOcupacaoAtual(),
                estacionamentoDiaDados.getQuantidadeTrocasDia(),
                estacionamentoDiaDados.getVagasOcupadas(),
                estacionamentoDiaDados.getVagasLivres(),
                estacionamentoDiaDados.getHorarioPico(),
                estacionamentoDiaDados.getTempoTotalLivre(),
                estacionamentoDiaDados.getVagasSubutilizadas(),
                estacionamentoDiaDados.getVagasCriticas(),
                estacionamentoDiaDados.getDataHoraEvento(),
                estacionamentoDiaDados.getCreatedBy(),
                estacionamentoDiaDados.getLastModifiedBy(),
                estacionamentoDiaDados.getCreatedAt(),
                estacionamentoDiaDados.getUpdatedAt()
        );
    }
}
