package com.geop.AtualizacoesGerais.domain.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "fuxo_de_pessoas")
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Estacionamento extends Entidade{
    //Dados gerais:
    @Column(name = "id_vaga", nullable = false, unique = true)
    private String idVaga;
    @Column(name = "localizacao", nullable = false)
    private String localizacao;
    @Column(name = "tipo_vaga", nullable = false)
    private String tipoVaga;
    @Column(name = "sensor_id")
    private String sensorId;
    @Column(name = "camera_id")
    private String cameraId;
    @Column(name = "placa_veiculo")
    private String placaVeiculo;
    //Dia
    @Column(name = "ocupada", nullable = false)
    private Boolean ocupada;
    @Column(name = "tempo_ocupacao_atual")
    private Integer tempoOcupacaoAtual; // minutos
    @Column(name = "quantidade_trocas_dia")
    private Integer quantidadeTrocasDia;
    @Column(name = "vagas_ocupadas")
    private Integer vagasOcupadas;
    @Column(name = "vagas_livres")
    private Integer vagasLivres;
    @Column(name = "horario_pico")
    private String horarioPico;
    @Column(name = "tempo_total_livre")
    private Integer tempoTotalLivre; // minutos
    @Column(name = "vagas_subutilizadas")
    private Boolean vagasSubutilizadas;
    @Column(name = "vagas_criticas")
    private Boolean vagasCriticas;
    //Longo prazo
    @Column(name = "taxa_rotatividade")
    private Double taxaRotatividade;
    @Column(name = "taxa_ocupacao")
    private Double taxaOcupacao;
    @Column(name = "dia_maior_movimento")
    private String diaMaiorMovimento;
    @Column(name = "media_diaria_entrada_veiculos")
    private Integer mediaDiariaEntradaVeiculos;
    //Analiticos
    @Column(name = "previsao_fluxo_proximo_horario")
    private String previsaoFluxoProximoHorario;
    @Column(name = "total_vagas")
    private Integer totalVagas;
    @Column(name = "evento_irregular_detectado")
    private String eventoIrregularDetectado;
    @Column(name = "data_hora_evento")
    private LocalDateTime dataHoraEvento;
    @Column(name = "percentual_uso_por_vaga")
    private Double percentualUsoPorVaga;
    @Column(name = "tempo_medio_ocupacao")
    private Integer tempoMedioOcupacao; // minutos
    @Column(name = "horario_de_pico_media")
    private Integer horarioDePicoMedia; //horas
}
