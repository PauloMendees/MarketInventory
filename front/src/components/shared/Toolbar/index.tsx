import LocalGroceryStoreIcon from "@mui/icons-material/LocalGroceryStore";
import { H5 } from "../Text";

export function Toolbar() {
  return (
    <>
      <div className="w-full bg-white pt-4 pb-4 pl-6 pr-6 z-40">
        <div className="flex gap-3 items-center">
          <LocalGroceryStoreIcon color="primary" />
          <H5 className="font-semibold text-primary-purple">{`MarketInventory`}</H5>
        </div>
      </div>
    </>
  );
}
