package com.study.store.Repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.study.store.Config.Database;
import com.study.store.Entities.Endereco;
import com.study.store.Entities.OrderRows;
import com.study.store.Entities.filter.FilterEndereco;
import com.study.store.Repositories.EnderecoDao;
import com.study.store.Repositories.mapper.EnderecoRowMapper;

public class EnderecoDaoImpl implements EnderecoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Database.dataSource());

    public Endereco findById(Integer id) {

        try {
            return this.jdbcTemplate.queryForObject(
                    "SELECT * FROM endereco where id = ?",
                    new EnderecoRowMapper(),
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Not find Emdereco//:400");
        }
    }

    @Override
    public Integer insert(Endereco endereco) {

        try {
            this.jdbcTemplate.update(
                    "INSERT INTO endereco (`rua`, `bairro`, `cidade`, `quadra`, `lote`, `cep`) " +
                            "VALUES (?, ?, ?, ?, ?, ?)",
                    endereco.getRua(),
                    endereco.getBairro(),
                    endereco.getCidade(),
                    endereco.getQuadra(),
                    endereco.getLote(),
                    endereco.getCep());
            return 0;
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in insert data Endereco//:400");
        }
    }

    @Override
    public int update(Endereco endereco) {

        try {

            this.jdbcTemplate.update(
                    "INSERT INTO endereco (`rua`, `bairro`, `cidade`, `quadra`, `lote`, `cep`) " +
                            "VALUES (?, ?, ?, ?, ?, ?)",
                    endereco.getRua(),
                    endereco.getBairro(),
                    endereco.getCidade(),
                    endereco.getQuadra(),
                    endereco.getLote(),
                    endereco.getCep());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in update data Endereco//:400");
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        try {

            this.jdbcTemplate.update(
                    "DELETE FROM Endereco WHERE id = ?",
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in delete data Endereco//:400");
        }
        return 0;
    }

    @Override
    public List<Endereco> search(FilterEndereco filter, OrderRows orderRows) {

        try {
            return this.jdbcTemplate.query(
                    "SELECT * FROM endereco"
                            + "WHERE `rua` = ?"
                            + "OR `bairro` = ?"
                            + "OR `cidade` = ?"
                            + "OR `quadra` = ?"
                            + "OR `lote` = ?"
                            + "OR `cep` = ?",
                    new EnderecoRowMapper(),
                    filter.getRua(),
                    filter.getBairro(),
                    filter.getCidade(),
                    filter.getQuadra(),
                    filter.getLote(),
                    filter.getCep());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Not find Emdereco//:400");
        }
    }
}
