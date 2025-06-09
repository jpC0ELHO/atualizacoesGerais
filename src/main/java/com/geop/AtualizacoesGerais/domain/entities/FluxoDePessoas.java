package com.geop.AtualizacoesGerais.domain.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "fuxo_de_pessoas")
@Data
@Entity
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FluxoDePessoas extends Entidade{
    @Column(name = "quantidade_acessos_horario",nullable = false)
    private Integer quantidadeAcessosHorario;
    @Column(name = "quantidade_acessos_dia",nullable = false)
    private Integer quantidadeAcessosDia;
    @Column(name = "quantidade_acessos_mes",nullable = false)
    private Integer quantidadeAcessosMes;
    @Column(name = "quantidade_acessos_ano",nullable = false)
    private Integer quantidadeAcessosAno;
    @Column(name = "quantidade_acessos_anos",nullable = false)
    private Integer quantidadeAcessosAnos;
    @Column(name = "valor_aferido",nullable = false)
    private Integer valorAferido;
    @Column(name = "valor_total",nullable = false)
    private Integer valorTotal;
    @Column(name = "valor_medio",nullable = false)
    private Integer valorMedio;
    @Column(name = "valor_divisao",nullable = false)
    private Integer valorDivisao;
    @Column(name = "valor_soma",nullable = false)
    private Integer valorSoma;
    @Column(name = "tempo_medio_permanencia",nullable = false)
    private Integer tempoMedioPermanencia;
}
