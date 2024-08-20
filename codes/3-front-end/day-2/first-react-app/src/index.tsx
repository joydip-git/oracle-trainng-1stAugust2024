import { createRoot } from "react-dom/client";
import App from "./App";

const appElement = App()

const rootDiv = document.getElementById('root') as HTMLElement
const rootElement = createRoot(rootDiv)
rootElement.render(appElement)