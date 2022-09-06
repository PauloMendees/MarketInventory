package com.study.store.UseCases.loja.deletar;

import com.study.store.Repositories.impl.LojaDaoImpl;

public class DeletarUseCases {

    public String execute(DeletarDTO props) {

        LojaDaoImpl lojaDaoImpl = new LojaDaoImpl();

        if (!(props.id instanceof Integer) || props.id == null || props.id == 0)
        throw new Error("//:Loja Inválido//:401");

        lojaDaoImpl.delete(props.id);

        return "Loja deletada com sucesso";
    }
}
