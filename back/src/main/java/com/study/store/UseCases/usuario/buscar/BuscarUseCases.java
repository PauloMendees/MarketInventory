package com.study.store.UseCases.usuario.buscar;

import java.util.List;

import com.study.store.Entities.Usuario;
import com.study.store.Repositories.impl.UsuarioDaoImpl;

public class BuscarUseCases {

    public List<Usuario> execute() {

        try {
            UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();

            return usuarioDaoImpl.findAll();
            
        } catch (Exception e) {
            throw new Error("O usuário não foi encontrado");
        }

    }
}
