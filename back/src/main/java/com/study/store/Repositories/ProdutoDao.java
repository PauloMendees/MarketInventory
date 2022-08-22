package com.study.store.Repositories;

import java.util.List;

import com.study.store.Entities.OrderRows;
import com.study.store.Entities.Produto;
import com.study.store.Entities.filter.FilterProduto;

public interface ProdutoDao {

    Produto findById(Integer id);

    void insert(Produto produto);

    int update(Produto produto);

    int delete(Integer id);

    List<Produto> search(FilterProduto filter, OrderRows orderRows);
}
