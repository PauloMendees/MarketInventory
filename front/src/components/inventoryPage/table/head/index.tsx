export function TableHead() {
  return (
    <thead>
      <tr className="flex gap-6 items-center h-auto w-full px-3">
        <th className="md:text-base xl:text-lg 2xl:text-lg font-semibold text-gray-800 flex justify-start w-[8%] min-w-[5rem]">
          {`Cod`}
        </th>
        <th className="md:text-base xl:text-lg 2xl:text-lg font-semibold text-gray-800 flex justify-start w-[15%] min-w-[5rem]">
          {`Nome`}
        </th>
        <th className="md:text-base xl:text-lg 2xl:text-lg font-semibold text-gray-800 flex justify-start w-[20%] min-w-[5rem]">
          {`Valor de compra`}
        </th>
        <th className="md:text-base xl:text-lg 2xl:text-lg font-semibold text-gray-800 flex justify-start w-[20%] min-w-[5rem]">
          {`Quantidade`}
        </th>
        <th className="md:text-base xl:text-lg 2xl:text-lg font-semibold text-gray-800 flex justify-start w-[20%] min-w-[5rem]">
          {`Loja`}
        </th>
        <th className="md:text-base xl:text-lg 2xl:text-lg font-semibold text-gray-800 flex justify-end w-full min-w-[5rem]">
          {`Ações`}
        </th>
      </tr>
    </thead>
  );
}
