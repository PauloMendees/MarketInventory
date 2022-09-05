import { useSnackbarContext } from "../../../../hooks/useSnackbarContext"
import { FormEvent } from "react"
import useRegisterProduto from "../../../../hooks/produto/useRegisterProduto";
import { ProdutoPayload } from "../../../../service/produtoService/types";

export default function useAddModal(){
    const {dispatchSnackbar} = useSnackbarContext();
    const {mutateAsync, isLoading} = useRegisterProduto();

    async function register(e?: FormEvent){
        {e ? e.preventDefault() : null}
        const nome = (document.getElementById('nomeInput') as HTMLInputElement).value
        const valor = (document.getElementById('valorCompra') as HTMLInputElement).value
        const quantidade = (document.getElementById('quantidadeInput') as HTMLInputElement).value
        const cod = (document.getElementById('codInput') as HTMLInputElement).value
        const lojaId = (document.getElementById('lojaSelect') as HTMLSelectElement).value

        const payload: ProdutoPayload = {
            cod: parseInt(cod),
            loja: parseInt(lojaId),
            nome,
            quantidade: parseInt(quantidade),
            valor_compra: parseInt(valor)
        }

        await mutateAsync(payload, {
            onSuccess: (res) => {
                dispatchSnackbar({type: "success", message: res.data})
            },
            onError: (err) => {
                //@ts-ignore
                dispatchSnackbar({type: "error", message: err.response.data.error})
            }
        })
    }

    return {register, isLoading}
}