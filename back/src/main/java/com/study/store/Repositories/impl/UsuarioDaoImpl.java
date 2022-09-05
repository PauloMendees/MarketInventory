package com.study.store.Repositories.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.study.store.Config.Database;
import com.study.store.Entities.OrderRows;
import com.study.store.Entities.Usuario;
import com.study.store.Entities.filter.FilterUsuario;
import com.study.store.Repositories.UsuarioDao;
import com.study.store.Repositories.mapper.UsuarioRowMapper;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Database.dataSource());

    public Usuario findById(Integer id) {

        try {
            return this.jdbcTemplate.queryForObject(
                    "SELECT * FROM usuario WHERE id = ?",
                    new UsuarioRowMapper(),
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Not find usuario//:400");
        }
    }

    @Override
    public int insert(Usuario usuario) {

        try {
            String insertSql = "INSERT INTO usuario (`apelido`, `senha`) " +
                    "VALUES (?, ?)";

            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            this.jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(insertSql, new String[] { "ID" });
                ps.setString(1, usuario.getApelido());
                ps.setString(2, usuario.getSenha());
                return ps;
            }, keyHolder);

            return keyHolder.getKey().intValue();
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in insert data Usuarios//:400");
        }
    }

    @Override
    public int update(Usuario usuario) {

        try {

            this.jdbcTemplate.update(
                    "INSERT INTO usuario (`apelido`, `senha`) " +
                            "VALUES (?, ?)",
                    usuario.getApelido(),
                    usuario.getSenha());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in update data Usuarios//:400");
        }
        return 0;
    }

    @Override
    public void delete(Integer id) {
        try {

            this.jdbcTemplate.update(
                    "DELETE FROM usuario WHERE id = ?",
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in delete data Usuarios//:400");
        }
    }

    @Override
    public List<Usuario> search(FilterUsuario filter, OrderRows orderRows) {
        try {

            return this.jdbcTemplate.query(
                    "SELECT * FROM usuario WHERE "
                            + "`apelido` = ?"
                            + " OR `senha` = ?",
                    new UsuarioRowMapper(),
                    filter.getApelido(),
                    filter.getSenha());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Not find usuario//:400");
        }
    }

    @Override
    public List<Usuario> findAll() {

        try {
            return this.jdbcTemplate.query(
                    "SELECT * FROM usuario",
                    new UsuarioRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Not find usuario//:400");
        }
    }
}
