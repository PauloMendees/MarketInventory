import { BroomIcon } from "../../../../assets/icons/Broom";
import { PenIcon } from "../../../../assets/icons/Pen";

export function TableCell() {
  return (
    <tr className="flex gap-6 items-center h-8 w-full bg-gray-100 rounded-lg px-3">
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[8%] min-w-[5rem]">
        {`1002`}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[15%] min-w-[5rem]">
        {`Televisão`}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[20%] min-w-[5rem]">
        {`R$1000,00`}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[20%] min-w-[5rem]">
        {`20`}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex justify-start w-[20%] min-w-[5rem]">
        {`Eletrossom`}
      </td>
      <td className="md:text-xs xl:text-sm 2xl:text-sm font-medium text-gray-800 flex gap-5 justify-end w-full min-w-[5rem]">
        <button className="hover:bg-primary-lightPurple p-1 rounded-full duration-100">
          <PenIcon />
        </button>
        <button className="hover:bg-primary-lightPurple p-1 rounded-full duration-100">
          <BroomIcon />
        </button>
      </td>
    </tr>
  );
}
