package com.geop.AtualizacoesGerais.api.services.estacionamentoService;

import com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO.*;
import com.geop.AtualizacoesGerais.domain.exceptions.ModelIntegrityViolationException;
import com.geop.AtualizacoesGerais.domain.exceptions.ModelNotFoundException;
import com.geop.AtualizacoesGerais.domain.exceptions.NullableException;
import com.geop.AtualizacoesGerais.domain.repositories.EstacionamentoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO.EstacionamentoRequest.toEntidade;


@AllArgsConstructor
@Service
@Log4j2
public class EstacionamentoServiceImp implements EstacionamentoService{
    private final EstacionamentoRepository estacionamentoRepository;
    private final SimpMessagingTemplate messagingTemplate;
    @Override
    public List<EstacionamentoResponse> findEstacionamentoList() {
        try {
            var findEstacionamentoList=estacionamentoRepository.findAll();
            if (findEstacionamentoList.isEmpty()){
               throw new ModelNotFoundException("List not found!");
            }
            return findEstacionamentoList.stream().map(EstacionamentoResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error: {}",e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<EstacionamentoResponse> findEstacionamentoId(UUID uuid) {
        var findEstacionamentoId=estacionamentoRepository.findById(uuid);
        if (findEstacionamentoId.isEmpty()){
            log.error("ID: {} not found!",uuid);
            throw new ModelNotFoundException("ID: "+uuid+" not found!");
        }
        return findEstacionamentoId.map(EstacionamentoResponse::toResponse);
    }

    @Override
    public List<EstacionamentoDiaResponse> findEstacionamentoDia(EstacionamentoDiaResponse estacionamentoDiaResponse) {
        var findEstacionamentoDados= estacionamentoRepository.findAllByDataHoje();
        if (findEstacionamentoDados==null){
            throw new NullableException("Lista nula ou vazia!");
        }
        return findEstacionamentoDados.stream().map(EstacionamentoDiaResponse::toResponse).toList();
    }

    @Override
    public List<EstacionamentoMesResponse> findEstacionamentoMes(EstacionamentoMesResponse estacionamentoMesResponse) {
        var findEstacionamentoDados=estacionamentoRepository.findAllByDataMes();
        if (findEstacionamentoDados.isEmpty()){
            throw new ModelNotFoundException("Lista nula ou vazia!");
        }
        return findEstacionamentoDados.stream().map(EstacionamentoMesResponse::toResponse).toList();
    }

    @Override
    public List<EstacionamentoAnoResponse> findEstacionamentoAno(EstacionamentoAnoResponse estacionamentoAnoResponse) {
        var findEstacionamentoDados=estacionamentoRepository.findAllByDataAno();
        if (findEstacionamentoDados.isEmpty()){
            log.error("List not found!");
            throw new ModelNotFoundException("List not found!");
        }
        return findEstacionamentoDados.stream().map(EstacionamentoAnoResponse::toResponse).toList();
    }

    @Override
    public void createEstacionamento(EstacionamentoRequest estacionamentoRequest) {
    var findEstacionamentoDados=estacionamentoRepository.findByIdVaga(estacionamentoRequest.idVaga());
    if (findEstacionamentoDados.isPresent()){
    throw new ModelIntegrityViolationException("Dados ja existentes, podendo haver conflito de dados, verifique e tente novamente");
    }
    estacionamentoRepository.save(toEntidade(estacionamentoRequest));
    }

    @Override
    public void updateEstacionamento(UUID uuid, EstacionamentoRequest estacionamentoRequest) {
    var findEstacionamentoId=estacionamentoRepository
            .findById(uuid)
            .orElseThrow(()-> new ModelNotFoundException("Id: "+uuid+" not found"));
        findEstacionamentoId.setIdVaga(estacionamentoRequest.idVaga());
        findEstacionamentoId.setLocalizacao(estacionamentoRequest.localizacao());
        findEstacionamentoId.setTipoVaga(estacionamentoRequest.tipoVaga());
        findEstacionamentoId.setSensorId(estacionamentoRequest.sensorId());
        findEstacionamentoId.setCameraId(estacionamentoRequest.cameraId());
        findEstacionamentoId.setPlacaVeiculo(estacionamentoRequest.placaVeiculo());

        findEstacionamentoId.setOcupada(estacionamentoRequest.ocupada());
        findEstacionamentoId.setTempoOcupacaoAtual(estacionamentoRequest.tempoOcupacaoAtual());
        findEstacionamentoId.setQuantidadeTrocasDia(estacionamentoRequest.quantidadeTrocasDia());
        findEstacionamentoId.setVagasOcupadas(estacionamentoRequest.vagasOcupadas());
        findEstacionamentoId.setVagasLivres(estacionamentoRequest.vagasLivres());
        findEstacionamentoId.setHorarioPico(estacionamentoRequest.horarioPico());
        findEstacionamentoId.setTempoTotalLivre(estacionamentoRequest.tempoTotalLivre());
        findEstacionamentoId.setVagasSubutilizadas(estacionamentoRequest.vagasSubutilizadas());
        findEstacionamentoId.setVagasCriticas(estacionamentoRequest.vagasCriticas());

        findEstacionamentoId.setTaxaRotatividade(estacionamentoRequest.taxaRotatividade());
        findEstacionamentoId.setTaxaOcupacao(estacionamentoRequest.taxaOcupacao());
        findEstacionamentoId.setDiaMaiorMovimento(estacionamentoRequest.diaMaiorMovimento());
        findEstacionamentoId.setMediaDiariaEntradaVeiculos(estacionamentoRequest.mediaDiariaEntradaVeiculos());

        findEstacionamentoId.setPrevisaoFluxoProximoHorario(estacionamentoRequest.previsaoFluxoProximoHorario());
        findEstacionamentoId.setTotalVagas(estacionamentoRequest.totalVagas());
        findEstacionamentoId.setEventoIrregularDetectado(estacionamentoRequest.eventoIrregularDetectado());
        findEstacionamentoId.setDataHoraEvento(estacionamentoRequest.dataHoraEvento());
        findEstacionamentoId.setPercentualUsoPorVaga(estacionamentoRequest.percentualUsoPorVaga());
        findEstacionamentoId.setTempoMedioOcupacao(estacionamentoRequest.tempoMedioOcupacao());
        findEstacionamentoId.setHorarioDePicoMedia(estacionamentoRequest.horarioDePicoMedia());
        estacionamentoRepository.save(findEstacionamentoId);


    }

    @Override
    public void deleteEstacionamento(UUID uuid) {
    try {
        var findEstacionamentoId=estacionamentoRepository
                .findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("ID : "+uuid+" para deletar não encontrado!"));
        estacionamentoRepository.delete(findEstacionamentoId);
    }catch (RuntimeException e){
        log.error("Error: {}",e.getMessage());
        throw e;
    }
    }
}
