import LocalGroceryStoreIcon from "@mui/icons-material/LocalGroceryStore";
import { H5 } from "../Text";

export function Toolbar() {
  return (
    <>
      <div className="w-full bg-white pt-4 pb-4 pl-6 pr-6 fixed z-50">
        <div className="flex gap-3 items-center">
          <LocalGroceryStoreIcon color="primary" />
          <H5 className="font-semibold text-primary-purple">{`MarketInventory`}</H5>
        </div>
      </div>
      <div className="w-full h-14" />
    </>
  );
}
