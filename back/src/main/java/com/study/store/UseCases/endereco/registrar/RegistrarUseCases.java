package com.study.store.UseCases.endereco.registrar;

import com.study.store.Entities.Endereco;
import com.study.store.Repositories.impl.EnderecoDaoImpl;

public class RegistrarUseCases {

    public String execute(RegistrarDTO props) {

        EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();

        Endereco endereco = new Endereco();
        endereco.rua = props.rua;
        endereco.bairro = props.bairro;
        endereco.cidade = props.cidade;
        endereco.cep = props.cep;
        endereco.lote = props.lote;
        endereco.quadra = props.quadra;

        enderecoDaoImpl.insert(endereco);

        return "Endereco cadastro com sucesso!";
    }
}
