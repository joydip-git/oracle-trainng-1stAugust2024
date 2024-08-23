//import { createElement, h } from "preact";
// export function App() {
//     const preactDivNode = createElement('div', {}, 'Welcome to Preact')
//     const preactDivNode = h('div', {}, 'Welcome to Preact')
//     return preactDivNode
// }
;
import ProductList from "./ProductList";
export function App() {
    return (
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
    )
}