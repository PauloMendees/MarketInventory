import { ItemAddIcon } from "../../../assets/icons/ItemAdd";
import { SearchIcon } from "../../../assets/icons/Search";
import { Button } from "../../shared/Button";
import { Input } from "../../shared/Input";

type Props = {
  filter?: string;
  handleFilter?: () => void;
};

export function Actions({ filter, handleFilter }: Props) {
  return (
    <div className="flex items-center justify-between">
      <div className="flex-1">
        <Input onLeftIcon={<SearchIcon />} />
      </div>
      <div className="flex-1 flex justify-end gap-4 items-center">
        <Button>
          <ItemAddIcon color="#fff" />
          {`Add`}
        </Button>
      </div>
    </div>
  );
}
