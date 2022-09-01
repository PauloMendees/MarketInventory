import {userRoutes} from "../../config/apiRoutes/user";
import {api} from "../handleApi"
import {UserPayload} from './types'

export default function userService(){
    const {register, login: loginRoute} = userRoutes

    async function login(payload: UserPayload){
        return await api.post<UserPayload[]>(loginRoute, payload).then((res) => res);
    }

    async function registerService(payload: UserPayload){
        return await api.post(register, payload).then((res) => res);
    }

    return {registerService, login}
}