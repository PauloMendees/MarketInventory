package com.study.store.UseCases.usuario.confirmarSenha;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.store.Entities.Usuario;

@RestController("UsuarioConfirmarSenhaController")
public class ConfirmarSenhaController {

    public ConfirmarSenhaUseCases buscarUseCases;

    public ConfirmarSenhaController() {
        this.buscarUseCases = new ConfirmarSenhaUseCases();
    }

    @PostMapping(value = "/api/usuario/confirmarSenha")
    public ResponseEntity<?> handle(@RequestBody ConfirmarSenhaDTO data) {

        List<Usuario> usuario;
        Integer code = 200;

        try {

            usuario = this.buscarUseCases.execute(data);

            code = 200;
        } catch (Exception e) {
            throw new Error("//:Problem the in service//:500");
        }

        return ResponseEntity.status(code).body(usuario);
    }
}
