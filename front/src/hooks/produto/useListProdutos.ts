import { useQuery } from "@tanstack/react-query";
import produtoService from "../../service/produtoService";

function produtoQuery(){
    return produtoService().list().then((res) => res)
}

export default function useListProdutos(){
    const query = useQuery(['produtolist'], produtoQuery)

    return query;
}