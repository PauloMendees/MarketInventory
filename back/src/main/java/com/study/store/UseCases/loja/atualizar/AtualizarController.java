package com.study.store.UseCases.loja.atualizar;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("LojaAtualizarController")
public class AtualizarController {

    public AtualizarUseCases atualizarUseCases;

    public AtualizarController() {
        this.atualizarUseCases = new AtualizarUseCases();
    }

    @PostMapping(value = "/api/loja/atualizar", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> handle(@RequestBody AtualizarDTO data) {

        String resp = "A ação não foi concluída com sucesso!";
        Integer code = 401;

        try {

            resp = this.atualizarUseCases.execute(data);

            code = 200;
        } catch (Exception e) {
            throw new Error("//:Problem the in service//:500");
        }

        return ResponseEntity.status(code).body(resp);
    }
}
