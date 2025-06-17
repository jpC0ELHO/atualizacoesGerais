package com.geop.AtualizacoesGerais.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.geop.AtualizacoesGerais.domain.entities.Estacionamento;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({
        "id_vaga", "localizacao", "tipo_vaga", "sensor_id", "camera_id", "placa_veiculo",
        "ocupada", "tempo_ocupacao_atual", "quantidade_trocas_dia", "vagas_ocupadas",
        "vagas_livres", "horario_pico", "tempo_total_livre", "vagas_subutilizadas",
        "vagas_criticas", "taxa_rotatividade", "taxa_ocupacao", "dia_maior_movimento",
        "media_diaria_entrada_veiculos", "previsao_fluxo_proximo_horario", "total_vagas",
        "evento_irregular_detectado", "data_hora_evento", "percentual_uso_por_vaga",
        "tempo_medio_ocupacao", "horario_de_pico_media"
})
public record EstacionamentoResponse(
        String idVaga,
        String localizacao,
        String tipoVaga,
        String sensorId,
        String cameraId,
        String placaVeiculo,
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
        @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
        LocalDateTime dataHoraEvento,
        Double percentualUsoPorVaga,
        Integer tempoMedioOcupacao,
        Integer horarioDePicoMedia
) {
    public static EstacionamentoResponse toResponse(Estacionamento estacionamento) {
        if (estacionamento == null) return null;

        return new EstacionamentoResponse(
                estacionamento.getIdVaga(),
                estacionamento.getLocalizacao(),
                estacionamento.getTipoVaga(),
                estacionamento.getSensorId(),
                estacionamento.getCameraId(),
                estacionamento.getPlacaVeiculo(),
                estacionamento.getOcupada(),
                estacionamento.getTempoOcupacaoAtual(),
                estacionamento.getQuantidadeTrocasDia(),
                estacionamento.getVagasOcupadas(),
                estacionamento.getVagasLivres(),
                estacionamento.getHorarioPico(),
                estacionamento.getTempoTotalLivre(),
                estacionamento.getVagasSubutilizadas(),
                estacionamento.getVagasCriticas(),
                estacionamento.getTaxaRotatividade(),
                estacionamento.getTaxaOcupacao(),
                estacionamento.getDiaMaiorMovimento(),
                estacionamento.getMediaDiariaEntradaVeiculos(),
                estacionamento.getPrevisaoFluxoProximoHorario(),
                estacionamento.getTotalVagas(),
                estacionamento.getEventoIrregularDetectado(),
                estacionamento.getDataHoraEvento(),
                estacionamento.getPercentualUsoPorVaga(),
                estacionamento.getTempoMedioOcupacao(),
                estacionamento.getHorarioDePicoMedia()
        );
    }
}