package com.study.store.UseCases.loja.buscar;

import com.study.store.Entities.Loja;
import com.study.store.Repositories.impl.LojaDaoImpl;

public class BuscarUseCases {

    public Loja execute(BuscarDTO props) {

        LojaDaoImpl lojaDaoImpl = new LojaDaoImpl();

        Loja loja = new Loja();
        loja = lojaDaoImpl.findById(props.id);

        return loja;
    }
}
