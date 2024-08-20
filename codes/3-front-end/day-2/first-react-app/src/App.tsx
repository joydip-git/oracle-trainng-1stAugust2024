import React from 'react';
import './App.css';

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
