import { useMutation, useQueryClient } from "@tanstack/react-query";
import lojasService from "../../service/lojasService";

function handleMutate(id: number){
    return lojasService().del(id).then((res) => res)
}

export default function useDelLoja(){
    const queryClient = useQueryClient()

    return useMutation(handleMutate, {
        onSuccess: () => {
            queryClient.invalidateQueries(['lojasQuery']);
        }
    });
}