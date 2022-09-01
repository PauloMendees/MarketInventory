import { useRouter } from "next/router";
import { EmpresaIcon } from "../../../assets/icons/Empresa";
import { ItemIcon } from "../../../assets/icons/Item";
import { UserAddIcon } from "../../../assets/icons/UserAdd";
import colors from "../../../styles/theme/colors";

type Props = {
  active?: "inventory" | "empresa" | "user";
};

export function SideNavigation({ active }: Props) {
  const router = useRouter();

  return (
    <>
      <div className="h-screen flex flex-col justify-center gap-4 fixed pl-4 pr-4 bg-white pb-20">
        <button
          onClick={() => {
            router.push("inventory");
          }}
          type="button"
          className="p-4 rounded-xl hover:bg-primary-lightPurple duration-200 cursor-pointer"
        >
          <ItemIcon
            width="25"
            height="25"
            hoverAnimate
            color={
              active === "inventory"
                ? colors.primary.purple
                : colors.primary.gray
            }
          />
        </button>
        <button
          onClick={() => {
            router.push("empresas");
          }}
          className="p-4 rounded-xl hover:bg-primary-lightPurple duration-200 cursor-pointer"
        >
          <EmpresaIcon
            width="25"
            height="25"
            hoverAnimate
            color={
              active === "empresa" ? colors.primary.purple : colors.primary.gray
            }
          />
        </button>
        <button className="p-4 rounded-xl hover:bg-primary-lightPurple duration-200 cursor-pointer">
          <UserAddIcon
            width="25"
            height="25"
            hoverAnimate
            color={
              active === "user" ? colors.primary.purple : colors.primary.gray
            }
          />
        </button>
      </div>
      <div className="h-full pl-24" />
    </>
  );
}
