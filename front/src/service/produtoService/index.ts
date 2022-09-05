import { produtoRoutes } from "../../config/apiRoutes/produto"
import { api } from "../handleApi"
import { Produto, ProdutoPayload } from "./types"

export default function produtoService(){
    const {del: delRoute, list: listRoute, register: registerRoute} = produtoRoutes

    async function list(){
        return await api.get<Produto[]>(listRoute).then((res) => res)
    }

    async function del(id: number){
        return await api.post(delRoute, {id}).then((res) => res)
    }

    async function register(payload: ProdutoPayload){
        return await api.post(registerRoute, payload).then((res) => res)
    }

    return {list, del, register}
}