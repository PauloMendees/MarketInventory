package com.study.store.Repositories;

import java.util.List;

import com.study.store.Entities.Loja;
import com.study.store.Entities.OrderRows;
import com.study.store.Entities.filter.FilterLoja;

public interface LojaDao {

    Loja findById(Integer id);

    void insert(Loja loja);

    int update(Loja loja);

    int delete(Integer id);

    List<Loja> search(FilterLoja filter, OrderRows orderRows);
}
