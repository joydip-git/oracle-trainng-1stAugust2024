import { useState } from 'react';
import Content from '../content/Content';
import Footer from '../footer/Footer';
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
  console.log('app rendered');
  const welcomeMessage = 'React JS'
  const footerMessage = 'Copyright, Oracle 2024'

  //state hook
  const [contentData, setContentData] = useState<string>('React JS is JavaScript library to create front-end UI')
  const [countValue, setCountValue] = useState<number>(0)
  // const contentData = arr[0]
  // const setContentData = arr[1]

  const updateCount = () => {
    setCountValue(
      (current) => {
        return current + 1
      }
    )
  }
  const updateContent = () => {
    console.log('called...');
    //let temp = contentData + '. It helps you create SPA type of application.'
    //setContentData(temp)
    setContentData(
      (currentState) => {
        return currentState + '. It helps you create SPA type of application.'
      }
    )
    console.log(contentData);
  }
  //const headerElement = Header({ dataValue: data, numValue:10 })
  const divReactElement = (
    <div>
      { /*headerElement*/}
      {/* <Header dataValue={welcomeMessage} /> */}

      <Header dataValue={welcomeMessage} numValue={countValue} numHandler={updateCount} />
      <br />
      <br />
      <Content contentValue={contentData} contentHandler={updateContent} />
      <br />
      <br />
      <Footer footerMessageValue={footerMessage} />
    </div>
  )

  return divReactElement
}

export default App;


// function useStateValue(initialStateData: any) {
//   let dataValue = initialStateData;
//   const update = (newData: any) => {
//     dataValue = newData;
//   }
//   return [dataValue, update]
// }
