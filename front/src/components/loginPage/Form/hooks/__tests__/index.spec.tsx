import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { act, render, renderHook } from "@testing-library/react";
import { ReactNode } from "react";
import useLoginForm from "../useLoginForm";
import React from 'react'
import { Form } from "../..";

const mockedMutateAsync = jest.fn()

type WrapperProps = {
    children: ReactNode;
};

const wrapper = () => {
    const queryClient = new QueryClient({
        defaultOptions: {
            queries: {
                retry: false
            }
        }
    });
    return ({children}: WrapperProps) => <QueryClientProvider client={queryClient}>{children}</QueryClientProvider>;
};

const setup = () => renderHook(() => useLoginForm(), {
    wrapper: wrapper()
});

jest.mock('../../../../../hooks/user/useLogin', () => {
    return jest.fn(() => ({
        mutateAsync: mockedMutateAsync,
        isLoading: false
    }))
})

describe(useLoginForm.name, () => {
    test('Testando funcionalidade de mostrar password, estado inicial', async () => {
        const {result} = setup();
        expect(result.current.showPassword).not.toBeTruthy()
    })

    test('Testando funcionalidade de mostrar password, estado após chamada da função', async () => {
        const {result} = setup();
        act(() => {result.current.handleShowPassword()})
        expect(result.current.showPassword).toBeTruthy()
    })

    test('Testando chamada para API', async () => {
        const {result} = setup();
        render(<Form />)
        act(() => {result.current.signin()})
        expect(mockedMutateAsync).toHaveBeenCalled();
    })
})