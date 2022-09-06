package com.study.store.UseCases.endereco;

public class EnderecoMocked {

    public String rua;
    public String bairro;
    public String cidade;
    public Integer quadra;
    public Integer lote;
    public String cep;

    public EnderecoMocked(){
        this.rua = "123";
        this.bairro = "seila";
        this.cidade = "testando";
        this.quadra = 100;
        this.lote = 1;
        this.cep = "seila";
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

}
