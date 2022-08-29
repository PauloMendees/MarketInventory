package com.study.store.UseCases.loja.mostrarEstoque;

import java.util.ArrayList;
import java.util.List;

import com.study.store.Entities.Loja;
import com.study.store.Entities.OrderRows;
import com.study.store.Entities.Produto;
import com.study.store.Entities.filter.FilterProduto;
import com.study.store.Repositories.impl.LojaDaoImpl;
import com.study.store.Repositories.impl.ProdutoDaoImpl;

public class MostrarEstoqueUseCases {

    public ArrayList<MostrarEstoqueDTO> execute() {

        LojaDaoImpl lojaDaoImpl = new LojaDaoImpl();
        ArrayList<MostrarEstoqueDTO> lojasEstoques = new ArrayList<>();
        MostrarEstoqueDTO mostrarEstoqueDTO = new MostrarEstoqueDTO();
        List<Loja> loja;
        loja = lojaDaoImpl.findAll();

        ProdutoDaoImpl produtoDaoImpl = new ProdutoDaoImpl();
        FilterProduto filterProduto = new FilterProduto();
        OrderRows orderRows = new OrderRows();
        ArrayList<ProdutoItem> produtoItem = new ArrayList<>();

        orderRows.setColuna("nome");
        orderRows.setOrdem("DESC");

        for (Loja lojaItem : loja) {

            mostrarEstoqueDTO.setLoja(lojaItem);
            filterProduto.setLoja(lojaItem);

            for (Produto produtosItem : produtoDaoImpl.search(filterProduto, orderRows)) {

                produtoItem.add(new ProdutoItem(produtosItem));

            }

            mostrarEstoqueDTO.setProdutos(produtoItem);
            lojasEstoques.add(mostrarEstoqueDTO);
        }

        return lojasEstoques;
    }
}
