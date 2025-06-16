package com.geop.AtualizacoesGerais.domain.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data
@Getter
@Setter
@Entity
@Table(name = "fuxo_de_pessoas")
@EntityListeners(AuditingEntityListener.class)
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

    public FluxoDePessoas(Integer quantidadeAcessosHorario, Integer quantidadeAcessosDia, Integer quantidadeAcessosMes,
                          Integer quantidadeAcessosAno, Integer quantidadeAcessosAnos,
                          Integer valorAferido, Integer valorTotal, Integer valorMedio,
                          Integer valorDivisao, Integer valorSoma, Integer tempoMedioPermanencia) {
        this.quantidadeAcessosHorario = quantidadeAcessosHorario;
        this.quantidadeAcessosDia = quantidadeAcessosDia;
        this.quantidadeAcessosMes = quantidadeAcessosMes;
        this.quantidadeAcessosAno = quantidadeAcessosAno;
        this.quantidadeAcessosAnos = quantidadeAcessosAnos;
        this.valorAferido = valorAferido;
        this.valorTotal = valorTotal;
        this.valorMedio = valorMedio;
        this.valorDivisao = valorDivisao;
        this.valorSoma = valorSoma;
        this.tempoMedioPermanencia = tempoMedioPermanencia;
    }
}
