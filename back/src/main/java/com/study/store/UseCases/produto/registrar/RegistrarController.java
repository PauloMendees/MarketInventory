package com.study.store.UseCases.produto.registrar;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("ProdutoRegistrarController")
public class RegistrarController {

    public RegistrarUseCases registrarUseCases;

    public RegistrarController() {
        this.registrarUseCases = new RegistrarUseCases();
    }

    @PostMapping(value = "/api/produto/registrar", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> handle(@RequestBody RegistrarDTO data) {

        String resp = "A ação não foi executada com sucesso!";
        Integer code = 200;

        try {

            resp = this.registrarUseCases.execute(data);

            code = 200;
        } catch (Exception e) {
            throw new Error("//:Problem the in service//:500" + e);
        }

        return ResponseEntity.status(code).body(resp);
    }
}
