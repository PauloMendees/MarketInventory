package com.study.store.Repositories.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.study.store.Entities.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs, int romNum) throws SQLException {

        try {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setApelido(rs.getString("username"));
            usuario.setSenha(rs.getString("password"));

            return usuario;
        } catch (Exception e) {
            throw new Error("//:Not find Usuario//:400");
        }

    }
}
