import { render } from 'preact';
import './style.css';
import First from './First';
import Second from './Second';

export function App() {
	return (
		<div>
			<First />
			<br />
			<Second />
		</div>
	)
}

render(<App />, document.getElementById('app'));
