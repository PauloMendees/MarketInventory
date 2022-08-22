package com.study.store.Repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.study.store.Config.Database;
import com.study.store.Entities.Loja;
import com.study.store.Entities.OrderRows;
import com.study.store.Entities.filter.FilterLoja;
import com.study.store.Repositories.LojaDao;
import com.study.store.Repositories.mapper.LojaRowMapper;

public class LojaDaoImpl implements LojaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Database.dataSource());

    public Loja findById(Integer id) {

        try {
            return this.jdbcTemplate.queryForObject(
                    "SELECT * FROM loja where id = ?",
                    new LojaRowMapper(),
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Not find Loja//:400");
        }
    }

    @Override
    public void insert(Loja loja) {

        try {

            this.jdbcTemplate.update(
                    "INSERT INTO loja (`nome`, `cnpj`, `endereco_id`) " +
                            "VALUES (?, ?, ?)",
                    loja.getNome(),
                    loja.getCnpj(),
                    loja.getEndereco().getId());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in insert data Loja//:400");
        }
    }

    @Override
    public int update(Loja loja) {

        try {

            this.jdbcTemplate.update(
                    "INSERT INTO loja (`nome`, `cnpj`, `endereco`) " +
                            "VALUES (?, ?, ?)",
                    loja.getNome(),
                    loja.getCnpj(),
                    loja.getEndereco().getId());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in update data Loja//:400");
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        try {

            this.jdbcTemplate.update(
                    "DELETE FROM loja WHERE id = ?",
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in delete data loja//:400");
        }
        return 0;
    }

    @Override
    public List<Loja> search(FilterLoja filter, OrderRows orderRows) {

        try {
            return this.jdbcTemplate.query(
                    "SELECT * FROM loja"
                            + "WHERE `nome` = ?"
                            + "OR `cnpj` = ?"
                            + "OR `endereco` = ?",
                    new LojaRowMapper(),
                    filter.getNome(),
                    filter.getCnpj(),
                    filter.getEndereco().getId());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Not find Loja//:400");
        }
    }
}
