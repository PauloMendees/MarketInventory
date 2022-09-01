import { NextPage } from "next";
import { parseCookies } from "nookies";
import { ItemAddIcon } from "../../assets/icons/ItemAdd";
import { SearchIcon } from "../../assets/icons/Search";
import { Actions } from "../../components/inventoryPage/actions";
import { Table } from "../../components/inventoryPage/table";
import { Button } from "../../components/shared/Button";
import { Input } from "../../components/shared/Input";
import { PageContainer } from "../../components/shared/PageContainer";
import { SideNavigation } from "../../components/shared/SideNavigation";
import { H2 } from "../../components/shared/Text";
import { Toolbar } from "../../components/shared/Toolbar";
import colors from "../../styles/theme/colors";

const Empresas: NextPage = () => {
  return (
    <PageContainer>
      <Toolbar />
      <div className="flex">
        <SideNavigation active="empresa" />
        <div className="m-10 w-full">
          <H2 className="font-semibold text-primary-gray mb-4">{`Empresas`}</H2>
          <div className="w-full bg-white p-5 rounded-lg">
            <Actions />
            <Table />
          </div>
        </div>
      </div>
    </PageContainer>
  );
};

export default Empresas;

export const getServerSideProps = async (ctx: any) => {
  const { 'loggedUser': user } = parseCookies(ctx)

  if(!user){
      return {
          redirect: {
              destination: '/',
              permanent: false
          }
      }
  }

  return {
      props: {}
  }
}