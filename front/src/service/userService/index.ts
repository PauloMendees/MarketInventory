import { userRoutes } from "../../config/apiRoutes/user";
import { api } from "../handleApi"
import {RegisterUserPayload} from './types'

export default function userService(){
    const {register} = userRoutes

    async function registerService(payload: RegisterUserPayload){
        return await api.post(register, payload).then((res) => res);
    }

    return {registerService}
}