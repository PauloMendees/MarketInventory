import useDelLoja from "../../../../../hooks/loja/useDelLoja";
import { useSnackbarContext } from "../../../../../hooks/useSnackbarContext";

export default function useTableCell() {
  const { mutateAsync, isLoading } = useDelLoja();
  const { dispatchSnackbar } = useSnackbarContext();

  async function deletar(id: string) {
    await mutateAsync(parseInt(id), {
      onSuccess: (res) => {
        dispatchSnackbar({ type: "success", message: res.data });
      },
      onError: (err) => {
        //@ts-ignore
        dispatchSnackbar({ type: "error", message: err.response.data.error });
      },
    });
  }

  return { deletar, isLoading };
}
