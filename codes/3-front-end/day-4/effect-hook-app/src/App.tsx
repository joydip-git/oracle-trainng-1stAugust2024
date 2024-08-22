import { useState } from 'react';
import './App.css';
import Nested from './Nested';
import Name from './Name';

function App() {
  const [value, setValue] = useState<number>(0)
  const [name, setName] = useState<string>('')
  const [show, setShow] = useState<boolean>(true)

  const increaseValue = () => {
    setValue(
      (currentValue) => {
        return currentValue + 1
      }
    )
  }
  const changeName = (newName: string) => {
    setName(newName)
  }
  return (
    <div className="App">
      <Name nameValue={name} nameChangeHandler={changeName} />
      <br />
      {
        show && <Nested numValue={value} numValueHandler={increaseValue} />
      }
      <br />
      <button type="button" onClick={
        () => setShow((currentShow) => !currentShow)
      }>
        {show ? 'Hide' : 'Show'}
      </button>
    </div>
  );
}

export default App;
