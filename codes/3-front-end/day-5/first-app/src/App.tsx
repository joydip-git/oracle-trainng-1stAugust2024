//import { createElement, h } from "preact";
// export function App() {
//     const preactDivNode = createElement('div', {}, 'Welcome to Preact')
//     const preactDivNode = h('div', {}, 'Welcome to Preact')
//     return preactDivNode
// }
;
import { useState } from "preact/hooks";
import ProductList from "./ProductList";
import ColorContext, { ColorContextType } from "./color-context";
export function App() {

    const [color, setColor] = useState('green')
    const changeColor = (colorName: string) => {
        setColor(colorName)
    }

    const initialConextData: ColorContextType = {
        colorName: color,
        changeColorHandler: changeColor
    }

    return (
        <ColorContext.Provider value={initialConextData}>
            <div>
                Welcome to Preact
                <br />
                <button type="button" onClick={(e) => console.log(e)}>Change</button>
                <br />
                <label htmlFor="txtName">Name: &nbsp;</label>
                <input type="text" id="txtName" onInput={e => console.log((e.target as HTMLInputElement).value)} />
                <br />
                <br />
                <ProductList />
            </div >
        </ColorContext.Provider>
    )
}