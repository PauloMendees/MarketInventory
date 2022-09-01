import { FormEvent, useState } from "react";
import useLogin from "../../../../hooks/user/useLogin"
import { useSnackbarContext } from "../../../../hooks/useSnackbarContext";
import { UserPayload } from "../../../../service/userService/types";
import {setCookie} from 'nookies'
import { useRouter } from "next/router";

export default function useLoginForm(){
    const {mutateAsync, isLoading} = useLogin();
    const {dispatchSnackbar} = useSnackbarContext();
    const [showPassword, setShowPassword] = useState<boolean>(false)

    function handleShowPassword(){
        setShowPassword(!showPassword)
    }

    const router = useRouter()

    async function signin(e: FormEvent){
        e.preventDefault()
        const apelidoInput = document.getElementById('usernameInput') as HTMLInputElement
        const senhaInput = document.getElementById('senhaInput') as HTMLInputElement

        const apelido = apelidoInput.value
        const senha = senhaInput.value

        const payload: UserPayload = {
            apelido,
            senha
        }

        await mutateAsync(payload, {
            onSuccess: (res) => {
                if(res.data.length === 0) {
                    dispatchSnackbar({type: "error", message: "Usuário ou senha inválidos"})
                } else {
                    setCookie(undefined, 'loggedUser', payload.apelido)
                    router.push('/inventory')
                }
            },
            onError: (err) => {
                //@ts-ignore
                dispatchSnackbar({type: "success", message: err.response.data})
            }
        })
    }

    return {signin, isLoading, showPassword, handleShowPassword}
}