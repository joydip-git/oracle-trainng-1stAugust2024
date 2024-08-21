import { createRoot } from "react-dom/client";
import App from "./components/app/App";


createRoot(
    document.getElementById('root') as HTMLElement
).render(<App />)

/*
//called the root component, which returns a React Element containing application design
const appElement = App()

//fetch the placeholder HTML element(a div) from HTML file
const rootDiv = document.getElementById('root') as HTMLElement

//treated that placeholder as a root element for React JS, by calling createRoot() method from 'react-fom/client' package and passing the HTML element
const rootElement: Root = createRoot(rootDiv)

//called the "render" method of that root element (of type Root) and passed the React element as returned by root component
rootElement.render(appElement)

//Note: the "render()" method of the root(of type Root) creates HTML elements from the React element as returned by the root component.this technique is known as "mounting".

// setTimeout(
//     () => {
//         rootElement.unmount()
//         console.log('unmounted...');
//     },
//     3000
// )
*/
