package com.study.store.UseCases.produto.atualizar;

import com.study.store.Entities.Loja;
import com.study.store.Entities.Produto;
import com.study.store.Repositories.impl.LojaDaoImpl;
import com.study.store.Repositories.impl.ProdutoDaoImpl;

public class AtualizarUseCases {

    public String execute(AtualizarDTO props) {

        ProdutoDaoImpl produtoDaoImpl = new ProdutoDaoImpl();

        if (!(props.id instanceof Integer) || props.id == null || props.id == 0)
            throw new Error("//:Informações inválidas//:401");

        Produto produto = new Produto();
        produto.setNome(props.nome);
        produto.setCod(props.cod);
        produto.setQuantidade(props.quantidade);
        produto.setValorCompra(props.valor_compra);

        Loja loja = new Loja();
        LojaDaoImpl lojaDaoImpl = new LojaDaoImpl();

        loja = lojaDaoImpl.findById(props.loja);

        produto.setLoja(loja);

        produtoDaoImpl.update(produto);

        return "Produto atualizado com sucesso";
    }
}
