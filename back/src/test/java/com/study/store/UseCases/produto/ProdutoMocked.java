package com.study.store.UseCases.produto;

public class ProdutoMocked {

    public String nome;
    public Double valor_compra;
    public Integer quantidade;
    public Integer cod;
    public Integer loja;
    public Integer id;

    public ProdutoMocked(){
        this.nome = "testando";
        this.valor_compra = 20.00;
        this.quantidade = 50;
        this.cod = 1;
        this.loja = 1;
        this.id = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(Double valor_compra) {
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

    public Integer getLoja() {
        return loja;
    }

    public void setLoja(Integer loja) {
        this.loja = loja;
    }
}
