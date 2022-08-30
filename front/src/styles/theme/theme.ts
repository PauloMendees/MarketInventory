import {createTheme, Theme} from '@mui/material';
import colors from './colors';

export const muiTheme: Theme = createTheme({
    typography: {
        fontFamily: 'Nunito Sans',
    },
    palette: {
        primary: {
            main: colors.primary.purple,
            light: colors.primary.lightPurple,
            dark: colors.primary.black,
        },
    },
});
