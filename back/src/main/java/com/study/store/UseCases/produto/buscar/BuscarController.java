package com.study.store.UseCases.produto.buscar;

import java.util.List;

import org.springframework.http.MediaType;
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

    @GetMapping(value = "/api/produto/buscar", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> handle(@RequestBody BuscarDTO data) {

        List<Produto> produto;
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
