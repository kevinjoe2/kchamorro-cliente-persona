package com.neoris.clientepersona.controllers;

import com.neoris.clientepersona.exceptions.ClientePersonaException;
import com.neoris.clientepersona.services.CustomerService;
import com.neoris.clientepersona.vos.CustomerRequestVo;
import com.neoris.clientepersona.vos.CustomerResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<Flux<CustomerResponseVo>> get(
            @RequestParam(value = "id", required = false) Long id
    ) {
        try {
            log.info("customers.get id:{}",id);
            HttpHeaders headers = new HttpHeaders();
            if (Objects.nonNull(id)) {
                return new ResponseEntity<>(customerService.findById(id).flux(), headers, HttpStatus.OK);
            }
            return new ResponseEntity<>(customerService.findAll(), headers, HttpStatus.OK);
        } catch (RuntimeException ex){
            log.error("***ERROR customers.get documentNumber:{}", id, ex);
            throw ClientePersonaException.builder().message("Error al obtener el recurso").cause(ex).build();
        }
    }

    @PostMapping
    public Mono<CustomerResponseVo> post(
            @RequestBody Mono<CustomerRequestVo> customerRequestDtoMono
    ){
        try {
            log.info("customers.post customerRequestDtoMono:{}",customerRequestDtoMono);
            return customerService.save(customerRequestDtoMono);
        } catch (RuntimeException ex){
            log.error("***ERROR customers.post customerRequestDtoMono:{}", customerRequestDtoMono, ex);
            throw ClientePersonaException.builder().message("Error al crear el recurso").cause(ex).build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Mono<CustomerResponseVo>> put(
            @PathVariable("id") Long id,
            @RequestBody Mono<CustomerRequestVo> customerRequestDtoMono
    ){
        try {
            log.info("customers.put id:{}, customerRequestDtoMono:{}", id, customerRequestDtoMono);
            return ResponseEntity.ok(customerService.update(id, customerRequestDtoMono));
        } catch (RuntimeException ex){
            log.info("*** ERROR customers.put id:{}, customerRequestDtoMono:{}", id, customerRequestDtoMono, ex);
            throw ClientePersonaException.builder().message("Error al actualizar el recurso").cause(ex).build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Mono<CustomerResponseVo>> patch(
            @PathVariable("id") Long id,
            @RequestBody Mono<CustomerRequestVo> customerRequestDtoMono
    ){
        try {
            log.info("customers.patch id:{}, customerRequestDtoMono:{}", id, customerRequestDtoMono);
            return ResponseEntity.ok(customerService.patch(id, customerRequestDtoMono));
        } catch (RuntimeException ex){
            log.info("*** ERROR customers.patch id:{}, customerRequestDtoMono:{}", id, customerRequestDtoMono, ex);
            throw ClientePersonaException.builder().message("Error al actualizar parcialmente el recurso").cause(ex).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Mono<Void>> delete(
            @PathVariable("id") Long id
    ){
        try {
            log.info("customers.delete id:{}", id);
            return ResponseEntity.ok(customerService.delete(id));
        } catch (RuntimeException ex){
            log.info("***ERROR customers.delete id:{}", id, ex);
            throw ClientePersonaException.builder().message("Error al eliminar el recurso").cause(ex).build();
        }
    }
}
