package com.study.store.UseCases.endereco.deletar;

import com.study.store.Repositories.impl.EnderecoDaoImpl;

public class DeletarUseCases {

    public String execute(DeletarDTO props) {

        EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();

        enderecoDaoImpl.delete(props.id);

        return "Endereco deletado com sucesso";
    }
}
