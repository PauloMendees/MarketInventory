package com.study.store.UseCases.loja;

public class LojaMocked {

    public String nome;
    public String cnpj;
    public String rua;
    public String bairro;
    public String cidade;
    public String estado;
    public Integer quadra;
    public Integer lote;
    public String cep;

    public LojaMocked(){
        this.nome = "Test";
        this.cnpj = "123456";
        this.rua = "123";
        this.bairro = "seila";
        this.cidade = "testando";
        this.estado = "seila";
        this.quadra = 100;
        this.lote = 1;
        this.cep = "seila";
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getQuadra() {
        return quadra;
    }

    public void setQuadra(Integer quadra) {
        this.quadra = quadra;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
