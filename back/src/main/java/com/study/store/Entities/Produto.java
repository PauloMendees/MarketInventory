package com.study.store.Entities;

public class Produto {

    private Integer id;
    public String nome;
    public Double valor_compra;
    public Integer Quantidade;
    public Integer cod;
    public Loja loja;

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
        return Quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        Quantidade = quantidade;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

}
