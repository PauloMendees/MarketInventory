import { useQuery } from "@tanstack/react-query";
import lojasService from "../../service/lojasService";

function listQuerys(){
    return lojasService().list().then((res) => res)
}

export default function useListLojas(){
    const query = useQuery(['lojasQuery'], listQuerys)
    return query
}