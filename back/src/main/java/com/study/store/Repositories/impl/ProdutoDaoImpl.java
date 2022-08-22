package com.study.store.Repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.study.store.Config.Database;
import com.study.store.Entities.OrderRows;
import com.study.store.Entities.Produto;
import com.study.store.Entities.filter.FilterProduto;
import com.study.store.Repositories.ProdutoDao;
import com.study.store.Repositories.mapper.ProdutoRowMapper;

public class ProdutoDaoImpl implements ProdutoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Database.dataSource());

    public Produto findById(Integer id) {

        try {
            return this.jdbcTemplate.queryForObject(
                    "SELECT * FROM produto where id = ?",
                    new ProdutoRowMapper(),
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Not find Produto//:400");
        }
    }

    @Override
    public void insert(Produto produto) {

        try {

            this.jdbcTemplate.update(
                    "INSERT INTO produto (`nome`, `valor_compra`, `quantidade`, `cod`, `loja`) " +
                            "VALUES (?, ?, ?, ?, ?)",
                    produto.getNome(),
                    produto.getValorCompra(),
                    produto.getQuantidade(),
                    produto.getCod(),
                    produto.getLoja().getId());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in insert data Produto//:400");
        }
    }

    @Override
    public int update(Produto produto) {

        try {

            this.jdbcTemplate.update(
                    "INSERT INTO usuario (`nome`, `valor_compra`, `quantidade`, `cod`, `loja`) " +
                            "VALUES (?, ?, ?, ?, ?)",
                    produto.getNome(),
                    produto.getValorCompra(),
                    produto.getQuantidade(),
                    produto.getCod(),
                    produto.getLoja().getId());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in update data produto//:400");
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        try {

            this.jdbcTemplate.update(
                    "DELETE FROM produto WHERE id = ?",
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Problem in delete data Produto//:400");
        }
        return 0;
    }

    @Override
    public List<Produto> search(FilterProduto filter, OrderRows orderRows) {

        try {
            return this.jdbcTemplate.query(
                    "SELECT * FROM usuario"
                            + "WHERE `nome` = ?"
                            + "OR `valor_compra` = ?"
                            + "OR `quantidade` = ?"
                            + "OR `cod` = ?"
                            + "OR `loja` = ?",
                    new ProdutoRowMapper(),
                    filter.getNome(),
                    filter.getValor_compra(),
                    filter.getQuantidade(),
                    filter.getCod(),
                    filter.getLoja());
        } catch (EmptyResultDataAccessException e) {
            throw new Error("//:Not find Produto//:400");
        }
    }

}
