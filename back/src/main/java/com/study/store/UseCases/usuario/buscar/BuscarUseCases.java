package com.study.store.UseCases.usuario.buscar;

import com.study.store.Entities.Usuario;
import com.study.store.Repositories.impl.UsuarioDaoImpl;

public class BuscarUseCases {

    public Usuario execute(String id) {

        try {
            UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

            Usuario usuario = new Usuario();
            usuario = usuarioDaoImpl.findById(Integer.parseInt(id));

            return usuario;
        } catch (Exception e) {
            throw new Error("O usuário não foi encontrado");
        }

    }
}
