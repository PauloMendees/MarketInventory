import { BroomIcon } from "../../../../assets/icons/Broom";
import LoadingIcon from "../../../../assets/icons/Loading";
import { Produto } from "../../../../service/produtoService/types";
import useTableCell from "./hooks/useTableCell";

type Props = {
  data: Produto
}

export function TableCell({data}: Props) {
  const {deletar, isLoading} = useTableCell();

  return (
    <tr className="flex gap-6 items-center h-8 w-full bg-gray-100 rounded-lg px-3">
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[8%] min-w-[5rem]">
        {data.cod}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[20%] min-w-[5rem]">
        {data.nome}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[25%] min-w-[5rem]">
        {data.valor_compra}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[20%] min-w-[5rem]">
        {data.quantidade}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[20%] min-w-[5rem]">
        {data.loja.nome}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex gap-5 justify-end w-full min-w-[5rem]">
        <button
          className="hover:bg-primary-lightPurple p-1 rounded-full duration-100"
          onClick={() => {
            deletar(data.id)
          }}
        >
          {isLoading ? <LoadingIcon /> : <BroomIcon />}
        </button>
      </td>
    </tr>
  );
}
