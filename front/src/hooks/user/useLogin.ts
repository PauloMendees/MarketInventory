import { useMutation } from "@tanstack/react-query";
import userService from "../../service/userService";
import { UserPayload } from "../../service/userService/types";

function handleMutate(payload: UserPayload){
    return userService().login(payload).then((res) => res)
}

export default function useLogin(){
    return useMutation(handleMutate)
}