import { render } from 'preact';

import './style.css';
import { App } from './App';

// const preactElement = App()

// render(preactElement, document.getElementById('app'));

render(<App />, document.getElementById('app'))
