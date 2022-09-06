package com.study.store.UseCases.produto.registrar;

import com.study.store.Entities.Loja;
import com.study.store.Entities.Produto;
import com.study.store.Repositories.impl.LojaDaoImpl;
import com.study.store.Repositories.impl.ProdutoDaoImpl;

public class RegistrarUseCases {

    public String execute(RegistrarDTO props) {

        ProdutoDaoImpl produtoDaoImpl = new ProdutoDaoImpl();

        if (!(props.nome instanceof String) || props.nome == null || props.nome == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.cod instanceof Integer) || props.cod == null || props.cod == 0)
            throw new Error("//:Informações inválidas//:401");
        if (!(props.quantidade instanceof Integer) || props.quantidade == null || props.quantidade == 0)
            throw new Error("//:Informações inválidas//:401");
        if (!(props.valor_compra instanceof Double) || props.valor_compra == null || props.valor_compra == 0.0)
            throw new Error("//:Informações inválidas//:401");
        if (!(props.loja instanceof Integer) || props.loja == null || props.loja == 0)
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

        return "Produto cadastrado com sucesso!";
    }
}
