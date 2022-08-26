import { ReactNode } from "react"

type Props = {
    children: ReactNode
}

export const PageContainer = ({children}: Props) => {
    return (
        <div className="min-h-screen h-full w-full">
            {children}
        </div>
    )
}