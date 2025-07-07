package com.geop.AtualizacoesGerais.api.services.inteligenciaAnaliticaService;

import com.geop.AtualizacoesGerais.api.dtos.inteligenciaAnaliticaDto.InteligenciaAnaliticaRequest;
import com.geop.AtualizacoesGerais.api.dtos.inteligenciaAnaliticaDto.InteligenciaAnaliticaResponse;
import com.geop.AtualizacoesGerais.domain.exceptions.ModelNotFoundException;
import com.geop.AtualizacoesGerais.domain.repositories.InteligenciaAnaliticaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.geop.AtualizacoesGerais.api.dtos.inteligenciaAnaliticaDto.InteligenciaAnaliticaRequest.toEntidade;

@Service
@AllArgsConstructor
@Log4j2
public class InteligenciaAnaliticaServiceImp implements InteligenciaAnaliticaService{

    private final InteligenciaAnaliticaRepository inteligenciaAnaliticaRepository;
    private  final SimpMessagingTemplate messagingTemplate;

    @Override
    public List<InteligenciaAnaliticaResponse> findInteligenciaList() {
        try {
            var findInteligenciaList=inteligenciaAnaliticaRepository.findAll();
            if (findInteligenciaList.isEmpty()){
                throw new ModelNotFoundException("Lista não encontrada!");
            }
            return findInteligenciaList.stream().map(InteligenciaAnaliticaResponse::toResponse).toList();
        }catch (RuntimeException e){
            log.error("Error; {}",e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<InteligenciaAnaliticaResponse> findInteligenciaId(UUID uuid) {
        return inteligenciaAnaliticaRepository.findById(uuid).map(InteligenciaAnaliticaResponse::toResponse)
                .or(()->{
                    log.error("ID: {} not found!",uuid);
                    throw new ModelNotFoundException("ID: "+uuid+"not found!");
                });
    }

    //Nesse parametro não há tratativa apenas o registro das informações, direto.
    @Override
    public void createInteligencia(InteligenciaAnaliticaRequest inteligenciaAnaliticaRequest) {
        inteligenciaAnaliticaRepository.save(toEntidade(inteligenciaAnaliticaRequest));
    }
    private BigDecimal calcularMediaMovel(List<Integer> valoresHistoricos) {
        if (valoresHistoricos == null || valoresHistoricos.isEmpty()) {
            return BigDecimal.ZERO;
        }

        int soma = valoresHistoricos.stream().mapToInt(Integer::intValue).sum();
        double media = (double) soma / valoresHistoricos.size();

        return BigDecimal.valueOf(media).setScale(2, RoundingMode.HALF_UP);
    }
    @Override
    public void updateInteligencia(UUID uuid, InteligenciaAnaliticaRequest inteligenciaAnaliticaRequest) {
        var findInteligenciaAnalitica=inteligenciaAnaliticaRepository
                .findById(uuid)
                .orElseThrow(()-> new ModelNotFoundException("ID: "+uuid+" não encontrado"));
        BigDecimal calcularPFlxuo=
    }

    @Override
    public void deleteInteligencia(UUID uuid) {

    }
}
