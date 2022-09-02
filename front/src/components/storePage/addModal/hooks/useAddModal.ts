import { FormEvent } from "react"
import useRegisterLoja from "../../../../hooks/loja/useRegisterLoja"
import { useSnackbarContext } from "../../../../hooks/useSnackbarContext"
import { LojaPayload } from "../../../../service/lojasService/types"

export default function useAddModal(){
    const {mutateAsync, isLoading} = useRegisterLoja()
    const {dispatchSnackbar} = useSnackbarContext();

    async function handleSubmit(e?: FormEvent){
        if(e) e.preventDefault()
        
        const nome = (document.getElementById('nomeInput') as HTMLInputElement).value
        const cnpj = (document.getElementById('cnpjInput') as HTMLInputElement).value
        const rua = (document.getElementById('ruaInput') as HTMLInputElement).value
        const bairro = (document.getElementById('bairroInput') as HTMLInputElement).value
        const cidade = (document.getElementById('cidadeInput') as HTMLInputElement).value
        const estado = (document.getElementById('estadoInput') as HTMLInputElement).value
        const quadra = (document.getElementById('quadraInput') as HTMLInputElement).value
        const lote = (document.getElementById('loteInput') as HTMLInputElement).value
        const cep = (document.getElementById('cepInput') as HTMLInputElement).value

        const payload: LojaPayload = {
            bairro,
            cep,
            cidade,
            cnpj,
            estado,
            lote: parseInt(lote),
            nome,
            quadra: parseInt(quadra),
            rua
        }

        await mutateAsync(payload, {
            onSuccess: (res) => {
                dispatchSnackbar({type: "success", message: res.data})
            },
            onError: (err) => {
                //@ts-ignore
                dispatchSnackbar({type: "success", message: err.response.data.message})
            }
        });
    }

    return {isLoading, handleSubmit}
}