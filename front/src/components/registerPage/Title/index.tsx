import { H5 } from "../../shared/Text";

export const Title = () => {
  return (
    <div className="flex items-center gap-4">
      <div className="w-2 h-2 rounded-full bg-primary-purple" />
      <H5 className="font-bold text-primary-black">{`Market Inventory`}</H5>
    </div>
  );
};
