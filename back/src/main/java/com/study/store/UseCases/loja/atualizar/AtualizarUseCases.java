package com.study.store.UseCases.loja.atualizar;

import com.study.store.Entities.Endereco;
import com.study.store.Entities.Loja;
import com.study.store.Repositories.impl.EnderecoDaoImpl;
import com.study.store.Repositories.impl.LojaDaoImpl;

public class AtualizarUseCases {

    public String execute(AtualizarDTO props) {

        LojaDaoImpl lojaDaoImpl = new LojaDaoImpl();

        Loja loja = new Loja();

        loja.setNome(props.nome);
        loja.setCnpj(props.cnpj);

        Endereco endereco = new Endereco();
        EnderecoDaoImpl enderecoDaoImpl = new EnderecoDaoImpl();
        endereco.setLote(props.lote);
        endereco.setBairro(props.bairro);
        endereco.setCidade(props.cidade);
        endereco.setQuadra(props.quadra);
        endereco.setRua(props.rua);
        endereco.setCep(props.cep);

        endereco.setId(enderecoDaoImpl.insert(endereco));

        loja.setEndereco(endereco);

        lojaDaoImpl.update(loja);

        return "Loja atualizado com sucesso";
    }
}
