package com.study.store.UseCases.loja.mostrarEstoque;

import com.study.store.Entities.Produto;

public class ProdutoItem {

    private Integer id;
    public String nome;
    public Double valor_compra;
    public Integer quantidade;
    public Integer cod;

    ProdutoItem(Produto props) {
        this.id = props.getId();
        this.nome = props.getNome();
        this.valor_compra = props.getValorCompra();
        this.quantidade = props.getQuantidade();
        this.cod = props.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorCompra() {
        return valor_compra;
    }

    public void setValorCompra(Double valor_compra) {
        this.valor_compra = valor_compra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

}
