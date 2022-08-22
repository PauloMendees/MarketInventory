package com.study.store.Repositories.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.study.store.Entities.Endereco;

public class EnderecoRowMapper implements RowMapper<Endereco> {

    @Override
    public Endereco mapRow(ResultSet rs, int romNum) throws SQLException {

        Endereco endereco = new Endereco();

        endereco.setRua(rs.getString("rua"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setCidade(rs.getString("cidade"));
        endereco.setQuadra(rs.getInt("quadra"));
        endereco.setLote(rs.getInt("lote"));
        endereco.setCep(rs.getString("cep"));

        return endereco;
    }

}
