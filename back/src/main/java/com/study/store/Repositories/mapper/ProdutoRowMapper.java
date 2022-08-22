package com.study.store.Repositories.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.study.store.Entities.Produto;
import com.study.store.Repositories.impl.LojaDaoImpl;

public class ProdutoRowMapper implements RowMapper<Produto> {

    @Override
    public Produto mapRow(ResultSet rs, int romNum) throws SQLException {

        Produto produto = new Produto();

        produto.setId(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setValorCompra(rs.getDouble("valor_compra"));
        produto.setQuantidade(rs.getInt("quantidade"));
        produto.setCod(rs.getInt("cod"));

        Integer lojaId = rs.getInt("loja_id");
        LojaDaoImpl lojaDaoImpl = new LojaDaoImpl();

        produto.setLoja(lojaDaoImpl.findById(lojaId));

        return produto;
    }

}
