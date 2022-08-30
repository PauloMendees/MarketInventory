import { TableCell } from "./cell";
import { TableHead } from "./head";

export function Table() {
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
