import { ItemAddIcon } from "../../../assets/icons/ItemAdd";
import { SearchIcon } from "../../../assets/icons/Search";
import { Button } from "../../shared/Button";
import { Input } from "../../shared/Input";
import { H2 } from "../../shared/Text";

type Props = {
  filter?: string;
  handleFilter?: () => void;
  openAddModal?: () => void;
};

export function Actions({ filter, handleFilter, openAddModal }: Props) {
  return (
    <div className="flex items-center justify-between">
      <div className="flex-1">
        <H2 className="font-semibold text-primary-gray mb-4">{`Empresas`}</H2>
      </div>
      <div className="flex-1 flex justify-end gap-4 items-center">
        <Button onClick={openAddModal}>
          <ItemAddIcon color="#fff" />
          {`Add`}
        </Button>
      </div>
    </div>
  );
}
