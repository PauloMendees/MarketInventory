package com.study.store.UseCases.loja.buscar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.study.store.Entities.Loja;

@RestController("LojaBuscarController")
public class BuscarController {

    public BuscarUseCases buscarUseCases;

    public BuscarController() {
        this.buscarUseCases = new BuscarUseCases();
    }

    @CrossOrigin
    @GetMapping(value = "/api/loja/buscar")
    public ResponseEntity<?> handle() {

        List<Loja> loja;
        Integer code = 200;

        try {

            loja = this.buscarUseCases.execute();

            code = 200;
        } catch (Exception e) {
            throw new Error("//:Problem the in service//:500");
        }

        return ResponseEntity.status(code).body(loja);
    }
}
