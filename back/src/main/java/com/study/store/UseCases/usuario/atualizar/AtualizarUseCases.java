package com.study.store.UseCases.usuario.atualizar;

import com.study.store.Entities.Usuario;
import com.study.store.Repositories.impl.UsuarioDaoImpl;

public class AtualizarUseCases {

    public String execute(AtualizarDTO props) {

        if (!(props.apelido instanceof String) || props.apelido == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.senha instanceof String) || props.senha == "")
            throw new Error("//:Informações inválidas//:401");

        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

        Usuario usuario = new Usuario();
        usuario.apelido = props.apelido;
        usuario.senha = props.senha;
        usuario.setId(props.id);

        usuarioDaoImpl.update(usuario);

        return "Usuário atualizado com sucesso";
    }
}
