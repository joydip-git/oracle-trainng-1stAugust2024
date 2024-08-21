import Header from '../header/Header';
import './App.css'
/*
function App() {
  const data = 'Welcome to React JS'
  const divReactElement = React.createElement(
    'div',
    { id: 'mainDiv' },
    data
  )
  return divReactElement
}

export default App;
*/
function App() {
  const data = 'Welcome to React JS'
  //const headerElement = Header({ dataValue: data })
  const divReactElement = (
    <div>
      { /*headerElement*/}
      <Header dataValue={data} />
      <br />
      <Header dataValue={data} numValue={10} />
    </div>
  )

  return divReactElement
}

export default App;
