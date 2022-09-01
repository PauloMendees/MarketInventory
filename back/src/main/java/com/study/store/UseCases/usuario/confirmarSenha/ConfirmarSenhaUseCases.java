package com.study.store.UseCases.usuario.confirmarSenha;

import java.util.List;

import com.study.store.Entities.OrderRows;
import com.study.store.Entities.Usuario;
import com.study.store.Entities.filter.FilterUsuario;
import com.study.store.Repositories.impl.UsuarioDaoImpl;

public class ConfirmarSenhaUseCases {

    public List<Usuario> execute(ConfirmarSenhaDTO props) {

        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
        List<Usuario> usuario;
        FilterUsuario filterUsuario = new FilterUsuario();
        filterUsuario.setSenha(props.senha);
        filterUsuario.setApelido(props.apelido);
        OrderRows orderRows = new OrderRows();
        orderRows.setColuna("apelidos");
        orderRows.setOrdem("ASC");

        usuario = usuarioDaoImpl.search(filterUsuario, orderRows);

        return usuario;
    }
}
