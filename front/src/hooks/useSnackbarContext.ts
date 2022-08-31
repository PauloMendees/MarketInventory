import {useContext} from 'react';
import { SnackbarContext } from '../context/SnackBar';

export const useSnackbarContext = () => {
    return useContext(SnackbarContext);
};
