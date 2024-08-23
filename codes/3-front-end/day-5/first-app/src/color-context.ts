import { createContext } from "preact";

export type ColorContextType = {
    colorName: string,
    changeColorHandler: (value: string) => void
}
const ColorContext = createContext<ColorContextType>({
    colorName: '',
    changeColorHandler: undefined
})

export default ColorContext