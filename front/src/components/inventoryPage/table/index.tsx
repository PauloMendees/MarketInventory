import { useEffect } from "react";
import useListProdutos from "../../../hooks/produto/useListProdutos";
import { TableCell } from "./cell";
import { TableHead } from "./head";

export function Table() {
  const {data} = useListProdutos();

  useEffect(() => {
    console.log(data)
  }, [data])

  return (
    <table className="w-full mt-8">
      <TableHead />
      <tbody className="flex flex-col gap-3 mt-2">
        <TableCell />
        <TableCell />
        <TableCell />
        <TableCell />
      </tbody>
    </table>
  );
}
