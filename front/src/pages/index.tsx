import type { NextPage } from "next";
import { Copy } from "../components/loginPage/Copy";
import { Form } from "../components/loginPage/Form";
import { Title } from "../components/loginPage/Title";
import { PageContainer } from "../components/shared/PageContainer";
import LocalGroceryStoreIcon from "@mui/icons-material/LocalGroceryStore";
import { parseCookies } from "nookies";

const Home: NextPage = () => {
  return (
    <PageContainer>
      <div className="w-full min-h-screen flex items-center justify-center bg-primary-lightPurple">
        <div className="w-[100%] sm:w-[100%] md:w-[90%] lg:w-[90%] xl:w-[80%] 2xl:w-[80%] h-[800px] bg-white rounded-xl">
          <div className="flex justify-between items-center">
            <div className="sm:p-6 md:p-6 lg:p-6 xl:p-8 2xl:p-10 p-6 flex-1 h-[800px] flex flex-col justify-between">
              <Title />
              <Form />
              <Copy />
            </div>
            <div className="sm:hidden md:hidden lg:hidden: xl:flex 2xl:flex hidden flex-1 h-[800px] w-full bg-backgroundColor rounded-r-xl  items-center justify-center">
              <LocalGroceryStoreIcon
                sx={{fontSize: 200}}
                fontSize={"large"}
                scale={2}
                color='primary'
              />
            </div>
          </div>
        </div>
      </div>
    </PageContainer>
  );
};

export default Home;

export const getServerSideProps = async (ctx: any) => {
  const { 'loggedUser': user } = parseCookies(ctx)

  if(user){
      return {
          redirect: {
              destination: '/inventory',
              permanent: false
          }
      }
  }

  return {
      props: {}
  }
}