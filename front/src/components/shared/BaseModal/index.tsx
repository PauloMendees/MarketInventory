import { Box, Modal } from "@mui/material";
import React, { JSXElementConstructor, ReactElement, ReactNode } from "react";
import CloseIcon from "../../../assets/icons/Close";
import { When } from "../When";
import useBaseModal from "./hooks/useBaseModal";

type Props = {
  open: boolean;
  handleClose: () => void;
  children: ReactElement<any, string | JSXElementConstructor<any>>;
  className?: string;
  title?: string
};

export function BaseModal({ handleClose, open, children, className, title }: Props) {
  const { containerModalStyle } = useBaseModal();

  return (
    <Modal open={open} onClose={handleClose}>
      <Box sx={containerModalStyle}>
        <div
          className={`w-full flex flex-col gap-5 ${className}`}
        >
          <When value={title}>
            <div className="flex items-center justify-between">
              <h2 className="text-lg font-bold">{title}</h2>
              <button
                onClick={() => {
                  handleClose();
                }}
              >
                <CloseIcon />
              </button>
            </div>
          </When>
          <When value={!title}>
            <div className="w-full flex justify-end items-center">
              <button
                onClick={() => {
                  handleClose();
                }}
              >
                <CloseIcon />
              </button>
            </div>
          </When>
        </div>
        {children}
      </Box>
    </Modal>
  );
}
