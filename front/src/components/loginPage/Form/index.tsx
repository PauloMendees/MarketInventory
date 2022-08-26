import { Button } from "../../shared/Button";
import { Input } from "../../shared/Input";
import { TitleForm } from "./TitleForm";

export const Form = () => {
  return (
    <div className="flex flex-col items-center gap-6 w-full">
      <TitleForm />
      <form className="w-[60%] flex flex-col gap-3">
        <Input label="Email" placeholder="Digite seu email" />
        <Input label="Senha" placeholder="Digite sua senha" />
        <Button type="submit" className="w-full mt-2">{`Entrar`}</Button>
        <span className="w-full text-center text-sm text-primary-gray">
          {`Não possui acesso? `}
          <a className="font-bold text-primary-purple hover:underline cursor-pointer">{`Crie um`}</a>
        </span>
      </form>
    </div>
  );
};
