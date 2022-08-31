import { Button } from "../../shared/Button";
import { Input } from "../../shared/Input";
import useRegisterForm from "./hooks/useRegisterForm";
import { TitleForm } from "./TitleForm";
import React from 'react'

export const Form = () => {

  const {handleSubmit, isLoading} = useRegisterForm()

  return (
    <div className="flex flex-col items-center gap-6 w-full">
      <TitleForm />
      <form id="registerForm" onSubmit={handleSubmit} className="w-[90%] sm:w-[90%] md:w-[70%] lg:w-[70%] xl:w-[70%] 2xl:w-[70%] flex flex-col gap-3">
        <Input isRequired id="usernameRegisterInput" label="Username" placeholder="Digite seu apelido" />
        <Input isRequired id="passwordRegisterInput" label="Senha" placeholder="Digite sua senha" />
        <Button id="submitButton" type="submit" className="w-full mt-2" isLoading={isLoading}>
          <span className="text-xs sm:text-sm md:text-sm lg:text-lg xl:text-lg 2xl:text-lg">{`Registrar`}</span></Button>
      </form>
    </div>
  );
};
