import React from 'react';
import CloseIcon from '../../../assets/icons/Close';
import { SnackbarProps } from '../../../context/SnackBar/types';
import { H5 } from '../Text';
import useSnackBar from './hooks/useSnackBar';

type Props = {
    snackbar: SnackbarProps;
    deleteSnackbar: () => void;
};

export const SnackbarMessage = ({deleteSnackbar, snackbar}: Props) => {
    const {handleDeleteSnackbar, show} = useSnackBar({deleteSnackbar, snackbar});

    return (
        <div
            className={`${snackbar.type === 'error' ? 'bg-alerts-red' : 'bg-alerts-green'} 
            transition-opacity duration-200 animate-fadeInAnimation ${show ? 'opacity-1' : 'opacity-0'}
            flex justify-between items-center absolute pointer-events-auto overflow-hidden 
            px-5 py-3 w-[400px] rounded-xl text-primary-white bg-no-repeat z-50`}
            style={{boxShadow: '0 0 10px #00000084'}}
            data-testid={'snackbarMessage-' + snackbar.type}
        >
            <div />
            <div className="flex flex-1 mr-5">
                <H5 className={'2xl:leading-5 text-center w-full text-white'}>{snackbar.message}</H5>
            </div>
            <span
                data-testid={'closeIcon'}
                className={'flex cursor-pointer p-1 rounded-xl w-5 h-5 transform hover:scale-125 active:scale-90'}
                onClick={handleDeleteSnackbar}
            >
                <CloseIcon width='10px' />
            </span>
        </div>
    );
};