import { BaseModal } from "../../shared/BaseModal";
import { Button } from "../../shared/Button";
import { Input } from "../../shared/Input";

type Props = {
  open: boolean;
  handleOpen: () => void;
};

export function AddModal({ handleOpen, open }: Props) {
  return (
    <BaseModal title="Adicionar loja" handleClose={handleOpen} open={open}>
      <form className="mt-7 flex justify-between items-center gap-2 sm:w-[400px] md:w-[500px] lg:w-[500px] xl:w-[700px] 2xl:w-[700px] flex-wrap">
        <Input isRequired id="nomeInput" label="Nome" className="w-full" />
        <Input
          isRequired
          id="valorCompra"
          label="Valor de Compra"
          className="w-full"
          type={"number"}
        />
        <Input
          isRequired
          id="quantidadeInput"
          label="Quantidade"
          className="w-full"
          type={"number"}
        />
        <Input
          isRequired
          id="codInput"
          label="Código"
          className="w-full"
          type={"number"}
        />
        <div className="w-full">
          <label
            className={`mb-1 text-primary-black text-xs sm:text-xs md:text-xs lg:text-xs xl:text-sm 2xl:text-sm duration-200`}
          >
            {`Loja`}
          </label>
          <select
            required
            className="py-1 text-primary-black outline-none w-full border-primary-black rounded-lg border-[1px] px-3 text-sm sm:text-sm md:text-sm lg:text-base xl:text-lg 2xl:text-lg"
          >
            <option>Teste</option>
          </select>
        </div>
        <div className="w-full flex justify-between items-center mt-5">
          <Button isOutlined>{`Cancelar`}</Button>
          <Button type={"submit"}>{`Registrar`}</Button>
        </div>
      </form>
    </BaseModal>
  );
}
