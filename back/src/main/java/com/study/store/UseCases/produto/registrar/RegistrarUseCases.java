package com.study.store.UseCases.produto.registrar;

import com.study.store.Entities.Loja;
import com.study.store.Entities.Produto;
import com.study.store.Repositories.impl.LojaDaoImpl;
import com.study.store.Repositories.impl.ProdutoDaoImpl;

public class RegistrarUseCases {

    public String execute(RegistrarDTO props) {

        ProdutoDaoImpl produtoDaoImpl = new ProdutoDaoImpl();

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

        return "Produto cadastrado com sucesso!";
    }
}
