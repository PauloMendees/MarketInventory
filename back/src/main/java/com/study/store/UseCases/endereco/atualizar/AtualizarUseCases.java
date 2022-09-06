package com.study.store.UseCases.endereco.atualizar;

import com.study.store.Entities.Endereco;
import com.study.store.Repositories.impl.EnderecoDaoImpl;

public class AtualizarUseCases {

    public String execute(AtualizarDTO props) {

        EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();

        if (!(props.id instanceof Integer) || props.id == null || props.id == 0)
        throw new Error("//:Informações inválidas//:401");

        Endereco endereco = new Endereco();
        endereco.rua = props.rua;
        endereco.bairro = props.bairro;
        endereco.cidade = props.cidade;
        endereco.cep = props.cep;
        endereco.lote = props.lote;
        endereco.quadra = props.quadra;

        enderecoDaoImpl.update(endereco);

        return "Endereco atualizado com sucesso";
    }
}
