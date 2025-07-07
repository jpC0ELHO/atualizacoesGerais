package com.geop.AtualizacoesGerais.api.controllers;

import com.geop.AtualizacoesGerais.api.dtos.fluxoDePessoasDto.FluxoDePessoasRequest;
import com.geop.AtualizacoesGerais.api.dtos.fluxoDePessoasDto.FluxoDePessoasResponse;
import com.geop.AtualizacoesGerais.api.services.fluxoDePessoasService.FluxoDePessoasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/fluxodepessoas/v1")
public class FluxoDePessoasController {

        private final FluxoDePessoasService fluxoDePessoasService;

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<FluxoDePessoasResponse>>findFluxoDePessoasList(){
            return ResponseEntity.status(HttpStatus.OK).body(fluxoDePessoasService.findFluxoDePessoasList());
        }
        @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Optional<FluxoDePessoasResponse>>findFluxoDePessoasId(@PathVariable UUID id){
            return ResponseEntity.status(HttpStatus.OK).body(fluxoDePessoasService.findFluxoDePessoasId(id));
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.CREATED)
        public void createFluxoDePessoas(@RequestBody FluxoDePessoasRequest fluxoDePessoasRequest){
            fluxoDePessoasService.createFluxoDePessoas(fluxoDePessoasRequest);
        }

        @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.OK)
        public void updateFluxoDePessoas(@PathVariable UUID id,@RequestBody FluxoDePessoasRequest fluxoDePessoasRequest){
            fluxoDePessoasService.updateFluxoDePessoas(id,fluxoDePessoasRequest);
        }
        @DeleteMapping(value = "/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteFluxoDePessoas(@PathVariable UUID id){
            fluxoDePessoasService.deleteFluxoDePessoas(id);
        }
}
