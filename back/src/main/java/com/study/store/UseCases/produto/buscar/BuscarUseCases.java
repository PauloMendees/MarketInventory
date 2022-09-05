package com.study.store.UseCases.produto.buscar;

import java.util.List;

import com.study.store.Entities.Produto;
import com.study.store.Repositories.impl.ProdutoDaoImpl;

public class BuscarUseCases {

    public List<Produto> execute() {

        ProdutoDaoImpl produtoDaoImpl = new ProdutoDaoImpl();

        return produtoDaoImpl.findAll();
    }
}
