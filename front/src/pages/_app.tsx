import "../styles/globals.css";
import type { AppProps } from "next/app";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { HTMLHead } from "../components/shared/HTMLHead";
import { ThemeProvider } from "@mui/material";
import { muiTheme } from "../styles/theme/theme";
import { SnackbarProvider } from "../context/SnackBar";

const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      refetchOnWindowFocus: false,
    },
  },
});

function MyApp({ Component, pageProps }: AppProps) {
  return (
    <ThemeProvider theme={muiTheme}>
      <QueryClientProvider client={queryClient}>
        <SnackbarProvider>
          <HTMLHead />
          <Component {...pageProps} />
        </SnackbarProvider>
      </QueryClientProvider>
    </ThemeProvider>
  );
}

export default MyApp;
