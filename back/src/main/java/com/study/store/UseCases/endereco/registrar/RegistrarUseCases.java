package com.study.store.UseCases.endereco.registrar;

import com.study.store.Entities.Endereco;
import com.study.store.Repositories.impl.EnderecoDaoImpl;

public class RegistrarUseCases {

    public String execute(RegistrarDTO props) {

        EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();

        if (!(props.bairro instanceof String) || props.bairro == null || props.bairro == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.cep instanceof String) || props.cep == null || props.cep == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.cidade instanceof String) || props.cidade == null || props.cidade == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.estado instanceof String) || props.estado == null || props.estado == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.lote instanceof Integer) || props.lote == null || props.lote == 0)
            throw new Error("//:Informações inválidas//:401");
        if (!(props.quadra instanceof Integer) || props.quadra == null || props.quadra == 0)
            throw new Error("//:Informações inválidas//:401");
        if (!(props.rua instanceof String) || props.rua == null || props.rua == "")
            throw new Error("//:Informações inválidas//:401");

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
