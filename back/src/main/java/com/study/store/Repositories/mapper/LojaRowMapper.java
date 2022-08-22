package com.study.store.Repositories.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.study.store.Entities.Loja;
import com.study.store.Repositories.impl.EnderecoDaoImpl;

public class LojaRowMapper implements RowMapper<Loja> {

    @Override
    public Loja mapRow(ResultSet rs, int romNum) throws SQLException {

        Loja loja = new Loja();

        loja.setNome(rs.getString("nome"));
        loja.setCnpj(rs.getString("cnpj"));

        Integer enderecoId = rs.getInt("endereco_id");

        EnderecoDaoImpl enderecoImpl = new EnderecoDaoImpl();
        loja.setEndereco(enderecoImpl.findById(enderecoId));

        return loja;
    }

}
