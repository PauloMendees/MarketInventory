import React, {createContext, ReactNode, useCallback, useState} from 'react';
import {SnackbarProps, SnackbarData, SnackbarContextData} from './types';
import {When} from '../../components/shared/When';
import { SnackbarMessage } from '../../components/shared/SnackBar';

export const SnackbarContext = createContext({dispatchSnackbar: () => {}} as SnackbarContextData);

const styleSnackbarContainer = {top: '24px', left: 'calc(50% - (400px / 2))'};

export const SnackbarProvider = ({children}: {children: ReactNode}) => {
    const [snackbar, setSnackbar] = useState<SnackbarProps>({} as SnackbarProps);
    const addSnackbar = useCallback(({type, message}: SnackbarData) => {
        setSnackbar({
            type: type,
            message: message,
            timestamp: new Date()
        });
    }, []);

    const deleteSnackbar = () => {
        setTimeout(() => setSnackbar({} as SnackbarProps), 200);
    };

    return (
        <SnackbarContext.Provider
            value={{
                dispatchSnackbar: addSnackbar
            }}
        >
            <When value={snackbar.message}>
                <div style={{...styleSnackbarContainer, position: 'fixed'}}>
                    <SnackbarMessage snackbar={snackbar} deleteSnackbar={deleteSnackbar} />
                </div>
            </When>
            {children}
        </SnackbarContext.Provider>
    );
};