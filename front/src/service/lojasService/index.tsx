import { lojasRoutes } from "../../config/apiRoutes/lojas"
import { api } from "../handleApi"
import { LojaPayload } from "./types"

export default function lojasService(){
    const {register: registerRoute, list: listRoute, delete: delRoute} = lojasRoutes

    async function del(id: number){
        return await api.post(delRoute, {id}).then((res) => res);
    }

    async function list(){
        return await api.get(listRoute).then((res) => res)
    }

    async function register(payload: LojaPayload){
        return await api.post(registerRoute, payload).then((res) => res)
    }

    return {register, list, del}
}