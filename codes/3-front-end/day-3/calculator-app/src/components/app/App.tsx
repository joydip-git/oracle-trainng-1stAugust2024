import { FormEvent, useState } from 'react';
import './App.css';
import Calculator from '../calculator/Calculator';

function App() {
  const [inputState, setInputState] = useState<string>('enter value here')
  const updateInput = (value: string) => {
    //console.log(value);
    setInputState(value)
  }
  return (
    <div className="App">
      <Calculator />
      <br />
      <br />
      <label htmlFor="txtValue">Value:&nbsp;</label>
      <input type="text" id='txtValue'
        value={inputState}
        onInput={
          (e) => updateInput((e.target as HTMLInputElement).value)
        }
      />
    </div>
  );
}

export default App;
