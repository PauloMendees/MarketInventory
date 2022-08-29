package com.study.store.Repositories;

import java.util.List;

import com.study.store.Entities.Endereco;
import com.study.store.Entities.OrderRows;
import com.study.store.Entities.filter.FilterEndereco;

public interface EnderecoDao {

    Endereco findById(Integer id);

    Integer insert(Endereco endereco);

    int update(Endereco endereco);

    void delete(Integer id);

    List<Endereco> search(FilterEndereco filter, OrderRows orderRows);
}
