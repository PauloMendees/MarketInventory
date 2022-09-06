package com.study.store.UseCases.usuario.deletar;

import com.study.store.Repositories.impl.UsuarioDaoImpl;

public class DeletarUseCases {

    public String execute(DeletarDTO props) {

        if (!(props.id instanceof Integer) || props.id == null || props.id == 0)
        throw new Error("//:Usuário inválido//:401");

        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

        usuarioDaoImpl.delete(props.id);

        return "Usuário deletado com sucesso";
    }
}
