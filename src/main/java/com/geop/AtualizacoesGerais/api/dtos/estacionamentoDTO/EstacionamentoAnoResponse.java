package com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.geop.AtualizacoesGerais.domain.entities.Estacionamento;
import com.geop.AtualizacoesGerais.domain.exceptions.NullableException;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({
        "id_vaga", "localizacao", "tipo_vaga", "sensor_id", "camera_id",
        "tempo_total_livre", "vagas_subutilizadas", "vagas_criticas",
        "taxa_rotatividade", "taxa_ocupacao", "dia_maior_movimento",
        "total_vagas", "evento_irregular_detectado", "percentual_uso_por_vaga",
        "tempo_medio_ocupacao", "horario_de_pico_media"
})
public record EstacionamentoAnoResponse(
        String idVaga,
        String localizacao,
        String tipoVaga,
        String sensorId,
        String cameraId,
        Integer tempoTotalLivre,
        Boolean vagasSubutilizadas,
        Boolean vagasCriticas,
        Double taxaRotatividade,
        Double taxaOcupacao,
        String diaMaiorMovimento,
        Integer totalVagas,
        String eventoIrregularDetectado,
        Double percentualUsoPorVaga,
        Integer tempoMedioOcupacao,
        Integer horarioDePicoMedia
) {
    public static EstacionamentoAnoResponse toResponse(Estacionamento estacionamento){
        if (estacionamento==null){
            throw new NullableException("Lista anual nula!");
        }
        return new EstacionamentoAnoResponse(
                estacionamento.getIdVaga(),
                estacionamento.getLocalizacao(),
                estacionamento.getTipoVaga(),
                estacionamento.getSensorId(),
                estacionamento.getCameraId(),
                estacionamento.getTempoTotalLivre(),
                estacionamento.getVagasSubutilizadas(),
                estacionamento.getVagasCriticas(),
                estacionamento.getTaxaRotatividade(),
                estacionamento.getTaxaOcupacao(),
                estacionamento.getDiaMaiorMovimento(),
                estacionamento.getTotalVagas(),
                estacionamento.getEventoIrregularDetectado(),
                estacionamento.getPercentualUsoPorVaga(),
                estacionamento.getTempoMedioOcupacao(),
                estacionamento.getHorarioDePicoMedia()
        );
    }
}