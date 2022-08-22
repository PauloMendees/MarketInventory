package com.study.store.UseCases.usuario.registrar;

import com.study.store.Entities.Usuario;
import com.study.store.Repositories.impl.UsuarioDaoImpl;

public class RegistrarUseCases {

    public String execute(RegistrarDTO props) {

        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

        Usuario usuario = new Usuario();
        usuario.apelido = props.apelido;
        usuario.senha = props.senha;

        usuarioDaoImpl.insert(usuario);

        return "Usuário cadastrado com sucesso!";
    }
}
