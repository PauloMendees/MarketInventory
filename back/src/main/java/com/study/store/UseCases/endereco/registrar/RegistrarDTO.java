package com.study.store.UseCases.endereco.registrar;

public class RegistrarDTO {

    public String rua;
    public String bairro;
    public String cidade;
    public Integer quadra;
    public Integer lote;
    public String cep;

    RegistrarDTO(RegistrarDTO props) {

        rua = props.rua;
        bairro = props.bairro;
        cidade = props.cidade;
        quadra = props.quadra;
        lote = props.lote;
        cep = props.cep;

    }

}
