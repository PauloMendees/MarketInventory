package com.study.store.UseCases.endereco.deletar;

import com.study.store.Repositories.impl.EnderecoDaoImpl;

public class DeletarUseCases {

    public String execute(DeletarDTO props) {

        EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();

        if (!(props.id instanceof Integer) || props.id == null || props.id == 0)
        throw new Error("//:Endereco Inválido//:401");

        enderecoDaoImpl.delete(props.id);

        return "Endereco deletado com sucesso";
    }
}
