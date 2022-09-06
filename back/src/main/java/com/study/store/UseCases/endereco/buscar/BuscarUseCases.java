package com.study.store.UseCases.endereco.buscar;

import com.study.store.Entities.Endereco;
import com.study.store.Repositories.impl.EnderecoDaoImpl;

public class BuscarUseCases {

    public Endereco execute(BuscarDTO props) {

        EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();

        if (!(props.id instanceof Integer) || props.id == null || props.id == 0)
        throw new Error("//:Informações inválidas//:401");

        Endereco endereco = new Endereco();
        endereco = enderecoDaoImpl.findById(props.id);

        return endereco;
    }
}
