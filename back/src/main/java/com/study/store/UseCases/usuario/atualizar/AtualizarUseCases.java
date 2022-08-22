package com.study.store.UseCases.usuario.atualizar;

import com.study.store.Entities.Usuario;
import com.study.store.Repositories.impl.UsuarioDaoImpl;

public class AtualizarUseCases {

    public String execute(AtualizarDTO props) {

        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

        Usuario usuario = new Usuario();
        usuario.apelido = props.apelido;
        usuario.senha = props.senha;

        usuarioDaoImpl.update(usuario);

        return "Usuário atualizado com sucesso";
    }
}
