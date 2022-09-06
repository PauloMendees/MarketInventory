package com.study.store.UseCases.usuario.confirmarSenha;

import java.util.List;

import com.study.store.Entities.OrderRows;
import com.study.store.Entities.Usuario;
import com.study.store.Entities.filter.FilterUsuario;
import com.study.store.Repositories.impl.UsuarioDaoImpl;

public class ConfirmarSenhaUseCases {

    public List<Usuario> execute(ConfirmarSenhaDTO props) {

        if (!(props.apelido instanceof String) || props.apelido == null || props.apelido == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.senha instanceof String) || props.senha == null || props.senha == "")
            throw new Error("//:Informações inválidas//:401");
            
        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
        List<Usuario> usuario;
        FilterUsuario filterUsuario = new FilterUsuario();
        filterUsuario.setSenha(props.senha);
        filterUsuario.setApelido(props.apelido);
        OrderRows orderRows = new OrderRows();
        orderRows.setColuna("apelidos");
        orderRows.setOrdem("ASC");

        usuario = usuarioDaoImpl.findByUserCredentials(filterUsuario, orderRows);

        if(usuario.isEmpty())
            throw new Error("//:Usuário não encontrado//:401");


        return usuario;
    }
}
