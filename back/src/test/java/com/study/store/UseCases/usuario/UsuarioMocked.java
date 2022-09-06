package com.study.store.UseCases.usuario;

public class UsuarioMocked {

    public Integer id;
    public String apelido;
    public String senha;

    public UsuarioMocked(){
        this.id = 0;
        this.apelido = "testando";
        this.senha = "123";
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
