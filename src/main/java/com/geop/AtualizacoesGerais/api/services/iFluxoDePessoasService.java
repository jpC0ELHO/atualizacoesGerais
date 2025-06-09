package com.geop.AtualizacoesGerais.api.services;

import com.geop.AtualizacoesGerais.api.dtos.FluxoDePessoasRequest;
import com.geop.AtualizacoesGerais.api.dtos.FluxoDePessoasResponse;
import com.geop.AtualizacoesGerais.domain.entities.FluxoDePessoas;
import com.geop.AtualizacoesGerais.domain.exceptions.ModelNotFoundException;
import com.geop.AtualizacoesGerais.domain.repositories.FluxoDePessoasRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.geop.AtualizacoesGerais.api.dtos.FluxoDePessoasRequest.toEntidade;

@Service
@Log4j2
@AllArgsConstructor
public class iFluxoDePessoasService implements FluxoDePessoasService{
    private final FluxoDePessoasRepository fluxoDePessoasRepository;
    private final SimpMessagingTemplate messagingTemplate;
    @Override
    public List<FluxoDePessoasResponse> findFluxoDePessoasList() {
        try {
            var findFluxoDePessoas=fluxoDePessoasRepository.findAll();
            if (findFluxoDePessoas.isEmpty()){
                throw new ModelNotFoundException("List not found!");
            }
            return findFluxoDePessoas.stream().map(FluxoDePessoasResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.info("Error: {}",e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<FluxoDePessoasResponse> findFluxoDePessoasId(UUID uuid) {
        return fluxoDePessoasRepository
                .findById(uuid)
                .map(FluxoDePessoasResponse::toResponse)
                .or(()->{
            log.error("ID: {} not found!",uuid);
            throw new ModelNotFoundException("ID: "+uuid+" not found!");
        });
    }

    @Override
    public void createFluxoDePessoas(FluxoDePessoasRequest fluxoDePessoasRequest) {
        FluxoDePessoas fluxoDePessoasSalvo=fluxoDePessoasRepository.save(toEntidade(fluxoDePessoasRequest));
        FluxoDePessoasResponse fluxoDePessoasResponse=FluxoDePessoasResponse.toResponse(fluxoDePessoasSalvo);
        messagingTemplate.convertAndSend("/topic/fluxoDePessoas",fluxoDePessoasResponse);
        log.info("Fluxo de pessoas salvo e enviado: {} ",fluxoDePessoasResponse);
    }

    @Override
    public void updateFluxoDePessoas(UUID uuid, FluxoDePessoasRequest fluxoDePessoasRequest) {
            var findFluxoDePessoasId=fluxoDePessoasRepository
                    .findById(uuid)
                    .orElseThrow(()-> new ModelNotFoundException("ID: "+uuid+" not found"));
            findFluxoDePessoasId.setQuantidadeAcessosHorario(fluxoDePessoasRequest.quantidadeAcessoHorario());
            findFluxoDePessoasId.setQuantidadeAcessosDia(fluxoDePessoasRequest.quantidadeAcessoDia());
            findFluxoDePessoasId.setQuantidadeAcessosMes(findFluxoDePessoasId.getQuantidadeAcessosMes());
            findFluxoDePessoasId.setQuantidadeAcessosAno(fluxoDePessoasRequest.quantidadeAcessoAno());
            findFluxoDePessoasId.setQuantidadeAcessosAnos(fluxoDePessoasRequest.quantidadeAcessoAnos());
            findFluxoDePessoasId.setValorAferido(fluxoDePessoasRequest.valorAferido());
            findFluxoDePessoasId.setValorTotal(fluxoDePessoasRequest.valorTotal());
            findFluxoDePessoasId.setValorMedio(fluxoDePessoasRequest.valorMedio());
            findFluxoDePessoasId.setValorDivisao(fluxoDePessoasRequest.valorDivisao());
            findFluxoDePessoasId.setValorSoma(fluxoDePessoasRequest.valorSoma());
            findFluxoDePessoasId.setTempoMedioPermanencia(fluxoDePessoasRequest.tempoMedioPermanencia());
            fluxoDePessoasRepository.save(findFluxoDePessoasId);
    }

    @Override
    public void deleteFluxoDePessoas(UUID uuid) {
    try {
        var findFluxoDePessoasId=fluxoDePessoasRepository
                .findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("ID: "+uuid+" not found!"));
        fluxoDePessoasRepository.delete(findFluxoDePessoasId);
    }catch (RuntimeException e){
        log.error("Error: {}",e.getMessage());
        throw e;
    }
    }
}
