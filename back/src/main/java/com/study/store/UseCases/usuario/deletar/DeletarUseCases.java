package com.study.store.UseCases.usuario.deletar;

import com.study.store.Repositories.impl.UsuarioDaoImpl;

public class DeletarUseCases {

    public String execute(DeletarDTO props) {

        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

        usuarioDaoImpl.delete(props.id);

        return "Usuário deletado com sucesso";
    }
}
