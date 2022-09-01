import { render, waitFor } from "@testing-library/react";
import { Form } from "..";
import React from 'react'
import { MockQueryProvider } from "../../../../utils/jest/mocks/mockQueryProvider";
import userEvent from '@testing-library/user-event';

const mockedHandleSubmit = jest.fn()
const mockedHandleShowPassword = jest.fn()

jest.mock("../hooks/useLoginForm", () => {
    return jest.fn(() => ({
        signin: mockedHandleSubmit,
        isLoading: false,
        handleShowPassword: mockedHandleShowPassword,
        showPassword: false
    }))
})

const setup = () => render(
    <MockQueryProvider>
        <Form />
    </MockQueryProvider>
)

describe(Form.name, () => {
    test('Testing initial interface', () => {
        setup()

        const title = document.getElementById("titleContainer");
        const form = document.getElementById("loginForm")

        expect(title).toBeInTheDocument()
        expect(form).toBeInTheDocument()
    })

    test('Should be possible to submit form', async () => {
        setup()

        const usernameInput = document.getElementById('usernameInput') as HTMLInputElement
        const passwordInput = document.getElementById('senhaInput') as HTMLInputElement
        const submitButton = document.getElementById('submitButton') as HTMLButtonElement

        await userEvent.type(usernameInput, 'mock')
        await userEvent.type(passwordInput, 'mock')
        await userEvent.click(submitButton)

        await waitFor(() => {
            expect(mockedHandleSubmit).toHaveBeenCalled()
        })
    })

    test('Should not be possible to submit form', async () => {
        setup()

        const usernameInput = document.getElementById('usernameInput') as HTMLInputElement
        const passwordInput = document.getElementById('senhaInput') as HTMLInputElement
        const submitButton = document.getElementById('submitButton') as HTMLButtonElement

        await userEvent.type(usernameInput, 'mock')
        await userEvent.click(submitButton)

        await waitFor(() => {
            expect(mockedHandleSubmit).not.toHaveBeenCalled()
        })
    })
})