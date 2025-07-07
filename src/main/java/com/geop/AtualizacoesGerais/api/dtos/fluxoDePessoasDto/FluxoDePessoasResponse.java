package com.geop.AtualizacoesGerais.api.dtos.fluxoDePessoasDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.geop.AtualizacoesGerais.domain.entities.FluxoDePessoas;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({"uuid","quantidadeAcessoHorario","quantidadeAcessoDia","quantidadeAcessoMes"
        , "quantidadeAcessoAno","quantidadeAcessoAnos","valorAferido","valorMedio","valorDivisao"
        ,"valorSoma","tempoMedioPermanencia"
        ,"createdBy","lastModifiedBy","createdAt","updatedAt"})
public record FluxoDePessoasResponse(
        Integer quantidadeAcessoHorario,
        Integer quantidadeAcessoDia,
        Integer quantidadeAcessoMes,
        Integer quantidadeAcessoAno,
        Integer quantidadeAcessoAnos,
        Integer valorAferido,
        Integer valorTotal,
        Integer valorMedio,
        Integer valorDivisao,
        Integer valorSoma,
        Integer tempoMedioPermanencia,
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
    public static FluxoDePessoasResponse toResponse(FluxoDePessoas fluxoDePessoas){
    if (fluxoDePessoas==null){
        return null;
    }
    return new FluxoDePessoasResponse(
      fluxoDePessoas.getQuantidadeAcessosHorario(),
      fluxoDePessoas.getQuantidadeAcessosDia(),
      fluxoDePessoas.getQuantidadeAcessosMes(),
      fluxoDePessoas.getQuantidadeAcessosAno(),
      fluxoDePessoas.getQuantidadeAcessosAnos(),
      fluxoDePessoas.getValorAferido(),
      fluxoDePessoas.getValorTotal(),
      fluxoDePessoas.getValorMedio(),
      fluxoDePessoas.getValorDivisao(),
      fluxoDePessoas.getValorSoma(),
      fluxoDePessoas.getTempoMedioPermanencia(),
      fluxoDePessoas.getCreatedBy(),
      fluxoDePessoas.getLastModifiedBy(),
      fluxoDePessoas.getCreatedAt(),
      fluxoDePessoas.getUpdatedAt()
    );
    }
}
