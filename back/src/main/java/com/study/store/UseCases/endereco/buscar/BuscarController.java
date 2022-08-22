package com.study.store.UseCases.endereco.buscar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.store.Entities.Endereco;

@RestController("EnderecoBuscarController")
public class BuscarController {

    public BuscarUseCases buscarUseCases;

    public BuscarController() {
        this.buscarUseCases = new BuscarUseCases();
    }

    @GetMapping(value = "/api/endereco/buscar")
    public ResponseEntity<?> handle(@RequestBody BuscarDTO data) {

        Endereco endereco = new Endereco();
        Integer code = 200;

        try {

            endereco = this.buscarUseCases.execute(data);

            code = 200;
        } catch (Exception e) {
            throw new Error("//:Problem the in service//:500");
        }

        return ResponseEntity.status(code).body(endereco);
    }
}
