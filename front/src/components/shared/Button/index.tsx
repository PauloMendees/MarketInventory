import React, { ReactNode } from "react";
import LoadingIcon from "../../../assets/icons/Loading";
import useButton from "./hooks/useButton";

type ButtonProps = {
  onClick?: (ev?: React.MouseEvent<HTMLElement>) => void;
  type?: "button" | "submit" | "reset" | undefined;
  dataTestId?: string;
  className?: string;
  isDisabled?: boolean;
  isOutlined?: boolean;
  isLoading?: boolean;
  children?: ReactNode;
};

export function Button(props: ButtonProps) {
  const { getAnimation } = useButton();

  return (
    <button
      disabled={props.isDisabled || props.isLoading}
      onClick={props.onClick}
      data-testid={props.dataTestId}
      type={props.type}
      className={
        props.isOutlined
          ? `flex justify-center items-center gap-5 px-3 h-10 border border-primary-purple bg-transparent text-primary-purple rounded-xl text-lg font-normal 
          ${getAnimation(props.isDisabled)} ${props.className} `
          : `flex justify-center items-center gap-5 px-3 h-10 bg-primary-purple text-white rounded-xl text-lg font-normal 
          ${getAnimation(props.isDisabled)} ${props.className} `
      }
    >
      {props.isLoading ? (
        <>
          <span className="font-normal text-lg text-primary-white leading-6">{`Carregando`}</span>
          <LoadingIcon />
        </>
      ) : (
        props.children
      )}
    </button>
  );
}