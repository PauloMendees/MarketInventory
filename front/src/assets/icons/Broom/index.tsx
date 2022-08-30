type Props = {
  width?: string;
  height?: string;
  hoverAnimate?: boolean;
  color?: string;
};

export function BroomIcon({ hoverAnimate, height, width, color }: Props) {
  return (
    <svg
      width={width ? width : "20"}
      height={height ? height : "20"}
      className={
        hoverAnimate ? `hover:opacity-70 duration-200 cursor-pointer` : ``
      }
      viewBox="0 0 32 40"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M15.5795 0.000178626C15.192 0.00623378 14.8226 0.165881 14.5527 0.444054C14.2827 0.722227 14.1342 1.09618 14.1398 1.48377V10.0711C12.7191 10.6566 11.702 12.0531 11.702 13.6725V14.6475H8.28919C4.80621 14.6475 1.95108 17.5027 1.95108 20.9857V21.9608C1.95108 29.5177 0.0751639 35.1493 0.0751639 35.1493C-0.0302352 35.4653 -0.0246402 35.8077 0.0910237 36.1201C0.206688 36.4325 0.425493 36.696 0.711261 36.8671C0.711261 36.8671 5.99485 40 14.6273 40C17.9349 40 20.8416 39.519 23.3784 38.9678C23.7087 39.0113 24.044 38.9407 24.3287 38.7678C27.8909 37.9182 30.3183 36.9566 30.3183 36.9566C30.6689 36.806 30.9468 36.5244 31.0927 36.1718C31.2386 35.8192 31.2409 35.4236 31.0992 35.0693C31.0992 35.0693 29.2537 30.5199 29.2537 21.9608V20.9857C29.2537 17.5027 26.3986 14.6475 22.9156 14.6475H19.5028V13.6725C19.5028 12.0531 18.4857 10.6566 17.065 10.0711V1.48377C17.0679 1.288 17.0313 1.09367 16.9576 0.912275C16.884 0.730884 16.7746 0.56613 16.6361 0.427777C16.4976 0.289425 16.3327 0.180289 16.1512 0.106839C15.9697 0.0333893 15.7753 -0.00288085 15.5795 0.000178626ZM15.5567 12.7164C15.5878 12.7174 15.6189 12.7174 15.65 12.7164C16.1781 12.7437 16.5775 13.135 16.5775 13.6725V16.1102C16.5775 16.4981 16.7316 16.8701 17.0059 17.1444C17.2802 17.4187 17.6522 17.5728 18.0401 17.5728H22.9156C24.8171 17.5728 26.3284 19.0842 26.3284 20.9857V21.4732H4.87636V20.9857C4.87636 19.0842 6.3877 17.5728 8.28919 17.5728H13.1647C13.5526 17.5728 13.9246 17.4187 14.1989 17.1444C14.4732 16.8701 14.6273 16.4981 14.6273 16.1102V13.6725C14.6273 13.1343 15.0276 12.7428 15.5567 12.7164ZM4.73924 24.3985H26.4598C26.721 30.1264 27.5097 33.2392 27.9701 34.6579C27.3129 34.9129 26.5947 35.2103 24.5382 35.7416C24.1549 34.5892 23.5649 32.5026 23.4013 28.7236C23.3989 28.5277 23.3572 28.3343 23.2787 28.1548C23.2001 27.9753 23.0863 27.8135 22.944 27.6788C22.8018 27.5441 22.6339 27.4394 22.4504 27.3709C22.2668 27.3024 22.0714 27.2714 21.8757 27.2798C21.68 27.2882 21.4879 27.3359 21.311 27.4199C21.134 27.504 20.9758 27.6227 20.8456 27.7691C20.7154 27.9155 20.6159 28.0865 20.5531 28.2721C20.4902 28.4576 20.4653 28.6539 20.4798 28.8493C20.6398 32.5428 21.2134 34.8401 21.6739 36.3396C19.5484 36.7436 17.2249 37.0747 14.6273 37.0747C13.1582 37.0747 11.9387 36.9119 10.7136 36.7605C11.0657 35.8353 11.4387 34.7157 11.6887 32.8849C11.7153 32.6943 11.7041 32.5003 11.6556 32.314C11.6071 32.1278 11.5223 31.9529 11.4061 31.7995C11.2899 31.6461 11.1446 31.5171 10.9785 31.4199C10.8124 31.3227 10.6287 31.2593 10.438 31.2332C10.2473 31.2072 10.0534 31.219 9.86728 31.268C9.68118 31.3171 9.50658 31.4023 9.35349 31.519C9.2004 31.6356 9.07183 31.7813 8.97515 31.9477C8.87846 32.1141 8.81557 32.298 8.79007 32.4887C8.532 34.3787 8.15416 35.5446 7.87401 36.2006C7.83769 36.2856 7.85952 36.2232 7.83021 36.2882C5.10171 35.6679 3.84067 35.1105 3.17947 34.7627C3.58088 33.4052 4.45289 29.9129 4.73924 24.3985Z"
        fill={color ? color : "#475467"}
      />
    </svg>
  );
}
