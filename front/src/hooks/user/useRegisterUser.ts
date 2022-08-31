import { useMutation } from "@tanstack/react-query";
import userService from "../../service/userService";
import { RegisterUserPayload } from "../../service/userService/types";

function handleMutate(payload: RegisterUserPayload){
    return userService().registerService(payload).then((res) => res)
}

export default function useRegisterUser(){
    return useMutation(handleMutate)
}