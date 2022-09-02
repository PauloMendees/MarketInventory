import { useMutation, useQueryClient } from "@tanstack/react-query";
import lojasService from "../../service/lojasService";
import { LojaPayload } from "../../service/lojasService/types";

function handleMutate(payload: LojaPayload){
    return lojasService().register(payload).then((res) => res)
}

export default function useRegisterLoja(){
    const queryClient = useQueryClient()

    return useMutation(handleMutate, {
        onSuccess: () => {
            queryClient.invalidateQueries(['lojasQuery']);
        }
    });
}