package com.study.store.UseCases.loja.registrar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("LojaRegistrarController")
public class RegistrarController {

    public RegistrarUseCases registrarUseCases;

    public RegistrarController() {
        this.registrarUseCases = new RegistrarUseCases();
    }

    @PostMapping(value = "/api/loja/registrar")
    public ResponseEntity<?> handle(@RequestBody RegistrarDTO data) {

        String resp = "A ação não foi executada com sucesso!";
        Integer code = 200;

        try {

            resp = this.registrarUseCases.execute(data);

            code = 200;
        } catch (Exception e) {
            throw new Error("//:Problem the in service//:500");
        }

        return ResponseEntity.status(code).body(resp);
    }
}
