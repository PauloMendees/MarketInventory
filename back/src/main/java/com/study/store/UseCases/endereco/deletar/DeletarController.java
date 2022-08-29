package com.study.store.UseCases.endereco.deletar;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("EnderecoDeletarController")
public class DeletarController {

    public DeletarUseCases deletarUseCases;

    public DeletarController() {
        this.deletarUseCases = new DeletarUseCases();
    }

    @PostMapping(value = "/api/endereco/deletar", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> handle(@RequestBody DeletarDTO data) {

        String resp = "A ação não foi concluída com sucesso!";
        Integer code = 401;

        try {

            resp = this.deletarUseCases.execute(data);

            code = 200;
        } catch (Exception e) {
            throw new Error("//:Problem the in service//:500");
        }

        return ResponseEntity.status(code).body(resp);
    }
}
