package com.study.store.Repositories;

import java.util.List;

import com.study.store.Entities.OrderRows;
import com.study.store.Entities.Usuario;
import com.study.store.Entities.filter.FilterUsuario;

public interface UsuarioDao {

    Usuario findById(Integer id);

    int insert(Usuario usuario);

    int update(Usuario usuario);

    void delete(Integer id);

    List<Usuario> search(FilterUsuario filter, OrderRows orderRows);

    List<Usuario> findByUserCredentials(FilterUsuario filter, OrderRows orderRows);

    List<Usuario> findAll();
}
