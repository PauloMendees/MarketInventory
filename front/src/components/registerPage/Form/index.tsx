import { Button } from "../../shared/Button";
import { Input } from "../../shared/Input";
import { TitleForm } from "./TitleForm";

export const Form = () => {
  return (
    <div className="flex flex-col items-center gap-6 w-full">
      <TitleForm />
      <form className="w-[90%] sm:w-[90%] md:w-[70%] lg:w-[70%] xl:w-[70%] 2xl:w-[70%] flex flex-col gap-3">
        <Input label="Email" placeholder="Digite seu email" />
        <Input label="Senha" placeholder="Digite sua senha" />
        <Button type="submit" className="w-full mt-2">
          <span className="text-xs sm:text-sm md:text-sm lg:text-lg xl:text-lg 2xl:text-lg">{`Registrar`}</span></Button>
      </form>
    </div>
  );
};
