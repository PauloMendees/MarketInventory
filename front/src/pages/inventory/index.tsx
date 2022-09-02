import { NextPage } from "next";
import { parseCookies } from "nookies";
import { ItemAddIcon } from "../../assets/icons/ItemAdd";
import { SearchIcon } from "../../assets/icons/Search";
import { Actions } from "../../components/inventoryPage/actions";
import { AddModal } from "../../components/inventoryPage/AddModal";
import { Table } from "../../components/inventoryPage/table";
import useBaseModal from "../../components/shared/BaseModal/hooks/useBaseModal";
import { Button } from "../../components/shared/Button";
import { Input } from "../../components/shared/Input";
import { PageContainer } from "../../components/shared/PageContainer";
import { SideNavigation } from "../../components/shared/SideNavigation";
import { H2 } from "../../components/shared/Text";
import { Toolbar } from "../../components/shared/Toolbar";
import colors from "../../styles/theme/colors";

const Inventory: NextPage = () => {
  const {open, handleOpen} = useBaseModal();

  return (
    <PageContainer>
      <Toolbar />
      <div className="flex">
        <SideNavigation active="inventory" />
        <div className="m-10 w-full">
          <div className="w-full bg-white p-5 rounded-lg">
            <Actions openAddModal={handleOpen} />
            <Table />
          </div>
        </div>
      </div>
      <AddModal handleOpen={handleOpen} open={open} />
    </PageContainer>
  );
};

export default Inventory;

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