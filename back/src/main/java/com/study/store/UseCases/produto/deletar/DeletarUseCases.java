package com.study.store.UseCases.produto.deletar;

import com.study.store.Repositories.impl.ProdutoDaoImpl;

public class DeletarUseCases {

    public String execute(DeletarDTO props) {

        ProdutoDaoImpl produtoDaoImpl = new ProdutoDaoImpl();

        if (!(props.id instanceof Integer) || props.id == null || props.id == 0)
        throw new Error("//:Produto Inválido//:401");

        produtoDaoImpl.delete(props.id);

        return "Usuário deletado com sucesso";
    }
}
