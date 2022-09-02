package com.study.store.UseCases.loja.buscar;

import java.util.List;

import com.study.store.Entities.Loja;
import com.study.store.Repositories.impl.LojaDaoImpl;

public class BuscarUseCases {

    public List<Loja> execute() {

        LojaDaoImpl lojaDaoImpl = new LojaDaoImpl();

        return lojaDaoImpl.findAll();
    }
}
