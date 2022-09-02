import { NextPage } from "next";
import { parseCookies } from "nookies";
import useBaseModal from "../../components/shared/BaseModal/hooks/useBaseModal";
import { PageContainer } from "../../components/shared/PageContainer";
import { SideNavigation } from "../../components/shared/SideNavigation";
import { H2 } from "../../components/shared/Text";
import { Toolbar } from "../../components/shared/Toolbar";
import { Actions } from "../../components/storePage/actions";
import { AddModal } from "../../components/storePage/addModal";
import { Table } from "../../components/storePage/table";

const Empresas: NextPage = () => {
  const {open, handleOpen} = useBaseModal();

  return (
    <PageContainer>
      <Toolbar />
      <div className="flex">
        <SideNavigation active="empresa" />
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