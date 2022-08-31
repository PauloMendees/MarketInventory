import { render, screen, waitFor } from "@testing-library/react";
import { Form } from "..";
import React from 'react'
import { MockQueryProvider } from "../../../../utils/jest/mocks/mockQueryProvider";
import userEvent from '@testing-library/user-event';

const mockedHandleSubmit = jest.fn()

jest.mock("../hooks/useRegisterForm", () => {
    return jest.fn(() => ({
        handleSubmit: mockedHandleSubmit,
        isLoading: false,
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
        const form = document.getElementById("registerForm")

        expect(title).toBeInTheDocument()
        expect(form).toBeInTheDocument()
    })

    test('Should be possible to submit form', async () => {
        setup()

        const usernameInput = document.getElementById('usernameRegisterInput') as HTMLInputElement
        const passwordInput = document.getElementById('passwordRegisterInput') as HTMLInputElement
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

        const usernameInput = document.getElementById('usernameRegisterInput') as HTMLInputElement
        const passwordInput = document.getElementById('passwordRegisterInput') as HTMLInputElement
        const submitButton = document.getElementById('submitButton') as HTMLButtonElement

        await userEvent.type(usernameInput, 'mock')
        await userEvent.click(submitButton)

        await waitFor(() => {
            expect(mockedHandleSubmit).not.toHaveBeenCalled()
        })
    })
})