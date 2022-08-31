import { FormEvent } from "react"
import useRegisterUser from "../../../../hooks/user/useRegisterUser"
import { useSnackbarContext } from "../../../../hooks/useSnackbarContext";
import { RegisterUserPayload } from "../../../../service/userService/types"

export default function useRegisterForm(){
    const {mutateAsync, isLoading, reset} = useRegisterUser()
    const {dispatchSnackbar} = useSnackbarContext();

    async function handleSubmit(e: FormEvent){
        e.preventDefault()
        const userNameInput = document.getElementById('usernameRegisterInput') as HTMLInputElement
        const passwordInput = document.getElementById('passwordRegisterInput') as HTMLInputElement
    
        const userName = userNameInput.value
        const password = passwordInput.value

        const payload: RegisterUserPayload = {
            apelido: userName,
            senha: password
        }

        await mutateAsync(payload, {
            onSuccess: (res) => {
                dispatchSnackbar({type: "success", message: res.data})
            }
        })
    }

    return {handleSubmit, isLoading}
}