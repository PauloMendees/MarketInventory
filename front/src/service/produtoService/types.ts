import { Empresa } from "../lojasService/types"

export type ProdutoPayload = {
    nome: string,
    valor_compra: number,
    quantidade: number,
    cod: number,
    loja: number
}

export type Produto = {
    cod: number,
    id: number,
    loja: Empresa,
    nome: string,
    quantidade: number,
    valorCompra: number,
    valor_compra: number
}