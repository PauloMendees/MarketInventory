import { BaseModal } from "../../shared/BaseModal";
import { Button } from "../../shared/Button";
import { Input } from "../../shared/Input";
import useAddModal from "./hooks/useAddModal";

type Props = {
  open: boolean;
  handleOpen: () => void;
};

export function AddModal({ handleOpen, open }: Props) {
  const {isLoading, handleSubmit} = useAddModal()

  return (
    <BaseModal title="Adicionar loja" handleClose={handleOpen} open={open}>
      <form onSubmit={handleSubmit} className="mt-7 flex justify-between items-center gap-2 sm:w-[400px] md:w-[500px] lg:w-[500px] xl:w-[700px] 2xl:w-[700px] flex-wrap">
        <Input isRequired id="nomeInput" label="Nome" className="lg:[40%] xl:[40%] 2xl:w-[40%] w-full" />
        <Input isRequired id="cnpjInput" label="CNPJ" className="lg:[54%] xl:[54%] 2xl:w-[54%] w-full" />
        <Input isRequired id="ruaInput" label="Rua" className="lg:[32%] xl:[32%] 2xl:w-[32%] w-full" />
        <Input isRequired id="bairroInput" label="Bairro" className="lg:[32%] xl:[32%] 2xl:w-[32%] w-full" />
        <Input isRequired id="cidadeInput" label="Cidade" className="lg:[32%] xl:[32%] 2xl:w-[32%] w-full"/>
        <Input isRequired id="estadoInput" label="Estado" className="lg:[32%] xl:[32%] 2xl:w-[32%] w-full"/>
        <Input isRequired id="quadraInput" type={"number"} label="Quadra" className="lg:[32%] xl:[32%] 2xl:w-[32%] w-full" />
        <Input isRequired id="loteInput" type={"number"} label="Lote" className="lg:[32%] xl:[32%] 2xl:w-[32%] w-full" />
        <Input isRequired id="cepInput" label="CEP" />
        <div className="w-full flex justify-between items-center mt-5">
            <Button isOutlined>
                {`Cancelar`}
            </Button>
            <Button type={"submit"} isLoading={isLoading}>
                {`Registrar`}
            </Button>
        </div>
      </form>
    </BaseModal>
  );
}
