package com.study.store.UseCases.usuario.buscar;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.store.Entities.Usuario;

@RestController("UsuarioBuscarController")
public class BuscarController {

    public BuscarUseCases buscarUseCases;

    public BuscarController() {
        this.buscarUseCases = new BuscarUseCases();
    }

    @CrossOrigin
    @GetMapping(value = "/api/usuario/buscar/")
    public ResponseEntity<?> handle() {

        List<Usuario> usuario;
        Integer code = 200;

        try {

            usuario = this.buscarUseCases.execute();

            code = 200;
        } catch (Exception e) {
            throw new Error("//:Problem the in service//:500");
        }

        return ResponseEntity.status(code).body(usuario);
    }
}
