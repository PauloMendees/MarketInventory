import {useEffect, useState} from 'react';
import { SnackbarProps } from '../../../../context/SnackBar/types';

type Props = {
    deleteSnackbar: () => void;
    snackbar: SnackbarProps;
};
export default function useSnackBar({deleteSnackbar, snackbar}: Props) {
    const TIME_TO_LIVE_NOTIFICATION_IN_SECONDS = 6;
    const TIME_TO_LIVE_NOTIFICATION_IN_MS = TIME_TO_LIVE_NOTIFICATION_IN_SECONDS * 1000;
    const [show, setShow] = useState(true);

    function handleDeleteSnackbar() {
        setShow(false);
        deleteSnackbar();
    }

    useEffect(() => {
        if (!snackbar.message) return;
        setShow(true);

        const interval = setInterval(() => {
            const threshold = Date.now() - TIME_TO_LIVE_NOTIFICATION_IN_MS;
            const snackbarUpdate = (snackbar: SnackbarProps) => {
                const isOldSnackbar = snackbar.timestamp.getTime() < threshold;
                if (isOldSnackbar) handleDeleteSnackbar();
            };

            snackbarUpdate(snackbar);
        }, 1000);
        return () => clearInterval(interval);
    }, [snackbar.message]);

    return {show, handleDeleteSnackbar};
}