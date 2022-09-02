import { useMutation, useQueryClient } from "@tanstack/react-query";
import produtoService from "../../service/produtoService";
import { ProdutoPayload } from "../../service/produtoService/types";

function handleMutate(payload: ProdutoPayload) {
  return produtoService()
    .register(payload)
    .then((res) => res);
}

export default function useRegisterProduto() {
  const queryClient = useQueryClient();

  return useMutation(handleMutate, {
    onSuccess: () => {
      queryClient.invalidateQueries(["produtolist"]);
    },
  });
}
