package com.study.store.UseCases.loja.deletar;

import com.study.store.Repositories.impl.LojaDaoImpl;

public class DeletarUseCases {

    public String execute(DeletarDTO props) {

        LojaDaoImpl lojaDaoImpl = new LojaDaoImpl();

        lojaDaoImpl.delete(props.id);

        return "Loja deletada com sucesso";
    }
}
