package com.study.store.UseCases.loja.mostrarEstoque;

import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("LojaMostrarEstoqueController")
public class MostrarEstoqueController {

    public MostrarEstoqueUseCases mostrarEstoqueUseCases;

    public MostrarEstoqueController() {
        this.mostrarEstoqueUseCases = new MostrarEstoqueUseCases();
    }

    @GetMapping(value = "/api/loja/mostrarEstoque")
    public ResponseEntity<?> handle() {

        ArrayList<MostrarEstoqueDTO> loja = new ArrayList<>();
        Integer code = 200;

        try {

            loja = this.mostrarEstoqueUseCases.execute();

            code = 200;
        } catch (Exception e) {
            throw new Error("//:" + e + "//:500");
        }

        return ResponseEntity.status(code).body(loja);
    }
}
