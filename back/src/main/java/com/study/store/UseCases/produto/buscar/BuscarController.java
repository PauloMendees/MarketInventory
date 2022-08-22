package com.study.store.UseCases.produto.buscar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.store.Entities.Produto;

@RestController("ProdutoBuscarController")
public class BuscarController {

    public BuscarUseCases buscarUseCases;

    public BuscarController() {
        this.buscarUseCases = new BuscarUseCases();
    }

    @GetMapping(value = "/api/produto/buscar")
    public ResponseEntity<?> handle(@RequestBody BuscarDTO data) {

        Produto produto = new Produto();
        Integer code = 200;

        try {

            produto = this.buscarUseCases.execute(data);

            code = 200;
        } catch (Exception e) {
            throw new Error("//:Problem the in service//:500");
        }

        return ResponseEntity.status(code).body(produto);
    }
}
