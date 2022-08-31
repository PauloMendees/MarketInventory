import React from 'react';
import {render, screen, waitFor} from '@testing-library/react';
import {SnackbarMessage} from '..';
import userEvent from '@testing-library/user-event';
import {messageType} from '../../../../@types/messageType';
import { SnackbarProps } from '../../../../context/SnackBar/types';

describe(SnackbarMessage.name, () => {
    const mockFnDeleteSnackbar = jest.fn();
    const snackbarMock = {
        timestamp: new Date(),
        message: 'mock',
        type: 'error'
    } as SnackbarProps;

    const setup = (type?: messageType) =>
        render(<SnackbarMessage snackbar={{...snackbarMock, type}} deleteSnackbar={mockFnDeleteSnackbar} />);

    it('Should display message in snackbar', async () => {
        setup();

        await waitFor(() => expect(screen.getByText('mock')).toBeInTheDocument());
    });

    it('Should display type error in snackbar', async () => {
        setup('error');

        await waitFor(() => expect(screen.getByTestId('snackbarMessage-error')).toBeInTheDocument());
        await waitFor(() => expect(screen.queryByTestId('snackbarMessage-success')).not.toBeInTheDocument());
    });

    it('Should display type success in snackbar', async () => {
        setup('success');

        await waitFor(() => expect(screen.getByTestId('snackbarMessage-success')).toBeInTheDocument());
        await waitFor(() => expect(screen.queryByTestId('snackbarMessage-error')).not.toBeInTheDocument());
    });

    it('Should call function on click in closeIcon', async () => {
        setup();

        const closeButton = screen.getByTestId('closeIcon');

        userEvent.click(closeButton);

        await waitFor(() => expect(mockFnDeleteSnackbar).toBeCalled());
    });
});