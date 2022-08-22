package com.study.store.UseCases.produto.deletar;

import com.study.store.Repositories.impl.ProdutoDaoImpl;

public class DeletarUseCases {

    public String execute(DeletarDTO props) {

        ProdutoDaoImpl produtoDaoImpl = new ProdutoDaoImpl();

        produtoDaoImpl.delete(props.id);

        return "Usuário deletado com sucesso";
    }
}
