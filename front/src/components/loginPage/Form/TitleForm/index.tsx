import { H2, H3, H4, H5 } from "../../../shared/Text";

export const TitleForm = () => {
  return (
    <div className="w-[90%] sm:w-[90%] md:w-[70%] lg:w-[70%] xl:w-[60%] 2xl:w-[60%] flex flex-col gap-2">
      <H3 className="font-semibold text-2xl text-primary-gray">{`Bem vindo de volta!`}</H3>
      <H5 className="font-normal text-sm text-primary-gray">{`Bem vindo de volta, por favor, coloque suas credenciais.`}</H5>
    </div>
  );
};
