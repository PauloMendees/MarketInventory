package com.study.store.UseCases.produto.buscar;

import com.study.store.Entities.Produto;
import com.study.store.Repositories.impl.ProdutoDaoImpl;

public class BuscarUseCases {

    public Produto execute(BuscarDTO props) {

        ProdutoDaoImpl produtoDaoImpl = new ProdutoDaoImpl();

        Produto produto = new Produto();
        produto = produtoDaoImpl.findById(props.id);

        return produto;
    }
}
