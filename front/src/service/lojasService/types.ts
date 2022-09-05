export type LojaPayload = {
    id?: number | string,
    nome: string,
    cnpj: string,
    rua: string,
    bairro: string,
    cidade: string,
    estado: string,
    quadra: number,
    lote: number,
    cep: string
}

export type Endereco = {
    bairro: string,
    cep: string,
    cidade: string,
    estado: string,
    id: string,
    lote: number,
    quadra: number,
    rua: string
  }
  
  export type Empresa = {
    cnpj: string,
    id: string,
    nome: string,
    endereco: Endereco;
  }