package com.study.store.UseCases.loja.mostrarEstoque;

import java.util.ArrayList;

import com.study.store.Entities.Loja;

public class MostrarEstoqueDTO {

    public Loja loja;
    public ArrayList<ProdutoItem> produtos;

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public ArrayList<ProdutoItem> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ProdutoItem> produtos) {
        this.produtos = produtos;
    }
}
