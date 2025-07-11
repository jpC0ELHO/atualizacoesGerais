package com.geop.AtualizacoesGerais.domain.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
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

    @Column(nullable = false, unique = true)
    private String idVaga;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private String tipoVaga;

    private String sensorId;
    private String cameraId;
    private String placaVeiculo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private EstacionamentoDiaDados dadosDiarios;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private EstacionamentoSemanaDados dadosSemanais;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private EstacionamentoMesDados dadosMensais;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private EstacionamentoAnoDados dadosAnuais;

    @Column(name = "data_ultima_atualizacao")
    private LocalDateTime dataUltimaAtualizacao;

    @Column(name = "usuario_responsavel")
    private String usuarioResponsavel;

}
