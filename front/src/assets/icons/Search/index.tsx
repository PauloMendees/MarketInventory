type Props = {
  width?: string;
  height?: string;
  hoverAnimate?: boolean;
  color?: string;
};

export function SearchIcon({ hoverAnimate, height, width, color }: Props) {
  return (
    <svg
      width={width ? width : "20"}
      height={height ? height : "20"}
      className={
        hoverAnimate ? `hover:opacity-70 duration-200 cursor-pointer` : ``
      }
      viewBox="0 0 40 39"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M16.1014 0C7.22857 0 0 7.0458 0 15.6943C0 24.3427 7.22857 31.3885 16.1014 31.3885C19.9395 31.3885 23.4677 30.067 26.2385 27.8709L37.1325 38.4894C37.286 38.6452 37.4699 38.7696 37.6733 38.8553C37.8767 38.941 38.0956 38.9863 38.3172 38.9885C38.5388 38.9907 38.7587 38.9498 38.9638 38.8681C39.169 38.7865 39.3554 38.6657 39.5121 38.513C39.6688 38.3603 39.7927 38.1786 39.8764 37.9786C39.9602 37.7786 40.0022 37.5644 39.9999 37.3484C39.9977 37.1324 39.9512 36.919 39.8633 36.7207C39.7754 36.5224 39.6478 36.3432 39.4879 36.1936L28.5939 25.5751C30.847 22.8743 32.2028 19.4353 32.2028 15.6943C32.2028 7.0458 24.9742 0 16.1014 0ZM16.1014 3.24709C23.1739 3.24709 28.8715 8.80065 28.8715 15.6943C28.8715 19.0524 27.5125 22.0864 25.3081 24.3215C25.1722 24.4188 25.0523 24.5357 24.9524 24.6682C22.6594 26.8168 19.5467 28.1414 16.1014 28.1414C9.02895 28.1414 3.33132 22.5879 3.33132 15.6943C3.33132 8.80065 9.02895 3.24709 16.1014 3.24709Z"
        fill={color ? color : "#475467"}
      />
    </svg>
  );
}
