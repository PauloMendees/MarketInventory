import type { NextPage } from "next";
import { Copy } from "../components/loginPage/Copy";
import { Form } from "../components/loginPage/Form";
import { Title } from "../components/loginPage/Title";
import { PageContainer } from "../components/shared/PageContainer";

const Home: NextPage = () => {
  return (
    <PageContainer>
      <div className="w-full min-h-screen flex items-center justify-center bg-primary-lightPurple">
        <div className="w-[80%] h-[800px] bg-white rounded-xl">
          <div className="flex justify-between items-center">
            <div className="p-10 flex-1 h-[800px] flex flex-col justify-between">
              <Title />
              <Form />
              <Copy />
            </div>
            <div className="flex-1 h-[800px] w-full bg-backgroundColor rounded-r-xl flex items-center justify-center">
              <div className="w-[250px] h-[250px] rounded-full bg-primary-purple" />
            </div>
          </div>
        </div>
      </div>
    </PageContainer>
  );
};

export default Home;
