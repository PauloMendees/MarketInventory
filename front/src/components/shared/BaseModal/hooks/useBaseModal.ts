import { useState } from "react"

export default function useBaseModal(){
    const [open, setOpen] = useState<boolean>(false)

    function handleOpen(){
        setOpen(!open)
    }

    const containerModalStyle = {
        position: 'absolute' as 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        minWidth: 250,
        bgcolor: 'background.paper',
        boxShadow: 24,
        p: 4,
        borderRadius: 2
    }

    return {open, handleOpen, containerModalStyle}
}