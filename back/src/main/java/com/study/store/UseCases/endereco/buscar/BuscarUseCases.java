package com.study.store.UseCases.endereco.buscar;

import com.study.store.Entities.Endereco;
import com.study.store.Repositories.impl.EnderecoDaoImpl;

public class BuscarUseCases {

    public Endereco execute(BuscarDTO props) {

        EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();

        Endereco endereco = new Endereco();
        endereco = enderecoDaoImpl.findById(props.id);

        return endereco;
    }
}
