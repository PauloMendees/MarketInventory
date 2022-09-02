import { useMutation, useQueryClient } from "@tanstack/react-query";
import produtoService from "../../service/produtoService";

function handleMutate(id: number){
    return produtoService().del(id).then((res) => res)
}

export default function useDelProduto(){
    const queryClient = useQueryClient()

    return useMutation(handleMutate, {
        onSuccess: () => {
            queryClient.invalidateQueries(['produtolist']);
        }
    })
}