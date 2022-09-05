import { useEffect } from "react";
import useListLojas from "../../../hooks/loja/useListLojas";
import { TableCell } from "./cell";
import { TableHead } from "./head";

export function Table() {
  const {data: apiResponse} = useListLojas()

  useEffect(() => {
    console.log(apiResponse?.data)
  }, [])

  return (
    <table className="w-full mt-8">
      <TableHead />
      <tbody className="flex flex-col gap-3 mt-2">
        {apiResponse?.data.map((item, index) => {
          return (
            <TableCell data={item} key={index} />
          )
        })}
      </tbody>
    </table>
  );
}
