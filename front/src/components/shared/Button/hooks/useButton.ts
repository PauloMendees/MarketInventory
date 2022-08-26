export default function useButton(){
    const getAnimation = (isDisabled: boolean | undefined) => {
        if (isDisabled) return " opacity-80 ";
        return "hover:opacity-90 duration-200";
      };

      return { getAnimation }
}