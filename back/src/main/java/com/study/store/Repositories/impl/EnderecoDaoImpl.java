package com.study.store.Repositories.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

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
            String insertSql = "INSERT INTO endereco (`rua`, `bairro`, `cidade`, `estado`, `quadra`, `lote`, `cep`) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            this.jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(insertSql, new String[] { "ID" });
                ps.setString(1, endereco.getRua());
                ps.setString(2, endereco.getBairro());
                ps.setString(3, endereco.getCidade());
                ps.setString(4, endereco.getEstado());
                ps.setInt(5, endereco.getQuadra());
                ps.setInt(6, endereco.getLote());
                ps.setString(7, endereco.getCep());
                return ps;
            }, keyHolder);
            
            return keyHolder.getKey().intValue();

        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in insert data Endereco//:400");
        }
    }

    @Override
    public int update(Endereco endereco) {

        try {

            this.jdbcTemplate.update(
                    "UPDATE endereco SET `rua` = ?, `bairro` = ?, `cidade` = ?, `quadra` = ?, `lote` = ?, `cep` = ? " +
                            "WHERE id = ?",
                    endereco.getRua(),
                    endereco.getBairro(),
                    endereco.getCidade(),
                    endereco.getQuadra(),
                    endereco.getLote(),
                    endereco.getCep(),
                    endereco.getId());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in update data Endereco//:400");
        }
        return 0;
    }

    @Override
    public void delete(Integer id) {
        try {

            this.jdbcTemplate.update(
                    "DELETE FROM Endereco WHERE id = ?",
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in delete data Endereco//:400");
        }
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
