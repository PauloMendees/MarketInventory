package com.study.store.UseCases.loja.registrar;

import com.study.store.Entities.Endereco;
import com.study.store.Entities.Loja;
import com.study.store.Repositories.impl.EnderecoDaoImpl;
import com.study.store.Repositories.impl.LojaDaoImpl;

public class RegistrarUseCases {

    public String execute(RegistrarDTO props) {

        LojaDaoImpl lojaDaoImpl = new LojaDaoImpl();

        if (!(props.nome instanceof String) || props.nome == null || props.nome == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.bairro instanceof String) || props.bairro == null || props.bairro == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.cep instanceof String) || props.cep == null || props.cep == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.cidade instanceof String) || props.cidade == null || props.cidade == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.cnpj instanceof String) || props.cnpj == null || props.cnpj == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.estado instanceof String) || props.estado == null || props.estado == "")
            throw new Error("//:Informações inválidas//:401");
        if (!(props.lote instanceof Integer) || props.lote == null || props.lote == 0)
            throw new Error("//:Informações inválidas//:401");
        if (!(props.quadra instanceof Integer) || props.quadra == null || props.quadra == 0)
            throw new Error("//:Informações inválidas//:401");
        if (!(props.rua instanceof String) || props.rua == null || props.rua == "")
            throw new Error("//:Informações inválidas//:401");

        Loja loja = new Loja();

        loja.setNome(props.nome);
        loja.setCnpj(props.cnpj);

        Endereco endereco = new Endereco();
        EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();
        endereco.setLote(props.lote);
        endereco.setBairro(props.bairro);
        endereco.setEstado(props.estado);
        endereco.setCidade(props.cidade);
        endereco.setQuadra(props.quadra);
        endereco.setRua(props.rua);
        endereco.setCep(props.cep);

        endereco.setId(enderecoDaoImpl.insert(endereco));
        
        loja.setEndereco(endereco);

        lojaDaoImpl.insert(loja);

        return "Loja cadastrada com sucesso!";
    }
}
