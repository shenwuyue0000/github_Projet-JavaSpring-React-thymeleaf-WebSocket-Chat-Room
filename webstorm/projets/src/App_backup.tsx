import React from 'react';
import logo from './logo.svg';
import './App.css';
import './test.js';
import './testt.js';
import ReactDOM from "react-dom/client";
//import {render} from "react-dom";



function App() {

  return (
      <html>
      <script src="https://unpkg.com/react@16/umd/react.production.min.js">
      </script> <script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js">
      </script> <script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
      <body>

<div className="App">

  <textarea id="history" readOnly></textarea>
  <input id="txtMessage" type="text"/>
  <button id="btnSend">Send message</button>
  <button id="btnClose">Close connection</button>

  

</div>

      </body>
      </html>

  );

}

// ReactDOM.createRoot(
//     document.getElementById('testt')
// ).render(<testt />);

export default App;
