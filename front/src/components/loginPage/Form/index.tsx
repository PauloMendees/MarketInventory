import { useRouter } from "next/router";
import EyeCloseIcon from "../../../assets/icons/EyeClose";
import EyeOpenIcon from "../../../assets/icons/EyeOpen";
import { webRoutes } from "../../../config/webRoutes";
import { Button } from "../../shared/Button";
import { Input } from "../../shared/Input";
import useLoginForm from "./hooks/useLoginForm";
import { TitleForm } from "./TitleForm";

export const Form = () => {
  const router = useRouter()
  const {signin, isLoading, handleShowPassword, showPassword} = useLoginForm();
  return (
    <div className="flex flex-col items-center gap-6 w-full">
      <TitleForm />
      <form onSubmit={signin} className="w-[90%] sm:w-[90%] md:w-[70%] lg:w-[70%] xl:w-[70%] 2xl:w-[70%] flex flex-col gap-3">
        <Input id="usernameInput" label="Username" placeholder="Digite seu apelido" />
        <Input
          id="senhaInput"
          label="Senha"
          placeholder="Digite sua senha"
          onRightIcon={ showPassword ? <EyeCloseIcon /> : <EyeOpenIcon /> }
          handleRightIconClick={handleShowPassword}
          type={showPassword ? 'text' : 'password'}
        />
        <Button isLoading={isLoading} type="submit" className="w-full mt-2">
          <span className="text-xs sm:text-sm md:text-sm lg:text-lg xl:text-lg 2xl:text-lg">{`Entrar`}</span></Button>
        <span className="w-full text-center text-sm text-primary-gray">
          {`Não possui acesso? `}
          <a onClick={() => { router.push(webRoutes.register) }} className="font-bold text-primary-purple hover:underline cursor-pointer">{`Crie um`}</a>
        </span>
      </form>
    </div>
  );
};
