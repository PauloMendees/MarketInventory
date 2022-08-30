import { NextPage } from "next";
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

const Home: NextPage = () => {
  return (
    <PageContainer>
      <Toolbar />
      <div className="flex">
        <SideNavigation active="inventory" />
        <div className="m-10 w-full">
          <H2 className="font-semibold text-primary-gray mb-4">{`Inventário`}</H2>
          <div className="w-full bg-white p-5 rounded-lg">
            <Actions />
            <Table />
          </div>
        </div>
      </div>
    </PageContainer>
  );
};

export default Home;
