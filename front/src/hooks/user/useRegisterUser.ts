import { useMutation } from "@tanstack/react-query";
import userService from "../../service/userService";
import { UserPayload } from "../../service/userService/types";

function handleMutate(payload: UserPayload){
    return userService().registerService(payload).then((res) => res)
}

export default function useRegisterUser(){
    return useMutation(handleMutate)
}