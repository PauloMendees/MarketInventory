import useDelProduto from "../../../../../hooks/produto/useDelProduto"
import { useSnackbarContext } from "../../../../../hooks/useSnackbarContext";

export default function useTableCell(){
    const {mutateAsync, isLoading} = useDelProduto();
    const {dispatchSnackbar} = useSnackbarContext();

    async function deletar(id: number){
        await mutateAsync(id, {
            onSuccess: (res) => {
                dispatchSnackbar({type: "success", message: res.data})
            },
            onError: (err) => {
                //@ts-ignore
                dispatchSnackbar({type: "error", message: err.response.data.error})
            }
        })
    }

    return {deletar, isLoading}
}