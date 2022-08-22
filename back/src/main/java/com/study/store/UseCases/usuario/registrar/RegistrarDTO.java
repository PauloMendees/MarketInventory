package com.study.store.UseCases.usuario.registrar;

public class RegistrarDTO {

    public String apelido;
    public String senha;

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
