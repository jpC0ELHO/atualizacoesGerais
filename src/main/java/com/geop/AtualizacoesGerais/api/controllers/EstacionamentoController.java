package com.geop.AtualizacoesGerais.api.controllers;

import com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO.EstacionamentoRequest;
import com.geop.AtualizacoesGerais.api.dtos.estacionamentoDTO.EstacionamentoResponse;
import com.geop.AtualizacoesGerais.api.services.estacionamentoService.EstacionamentoService;
import com.geop.AtualizacoesGerais.domain.entities.Estacionamento;
import com.geop.AtualizacoesGerais.domain.repositories.EstacionamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/estacionamento/")
@AllArgsConstructor
public class EstacionamentoController {
    private final EstacionamentoRepository estacionamentoRepository;
    private final EstacionamentoService estacionamentoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstacionamentoResponse>>findEstacionamentoList(){
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.findEstacionamentoList());
    }

    @GetMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<EstacionamentoResponse>>findEstacionamentoId(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.findEstacionamentoId(id));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEstacionamento(@RequestBody EstacionamentoRequest estacionamentoRequest){
        estacionamentoService.createEstacionamento(estacionamentoRequest);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateEstacionamento(@PathVariable UUID id,@RequestBody EstacionamentoRequest estacionamentoRequest){
        estacionamentoService.updateEstacionamento(id,estacionamentoRequest);
    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEstacionamento(@PathVariable UUID id){
        estacionamentoService.deleteEstacionamento(id);
    }
}
