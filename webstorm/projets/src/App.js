import React from 'react';
import logo from './logo.svg';
import './App.css';
import './test.js';
import './testt.js';
import ReactDOM from "react-dom/client";
import axios from "axios";
//import {render} from "react-dom";

function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return unescape(r[2]); return null;
}



class App extends React.Component {


    constructor(props) {
        super(props);

        // Initializing the state
        this.state = {
            user:{
                firstName:'',
                lastName:'',
                mail:''

            },

        };
    }

    componentDidMount() {
        let roomID=GetQueryString("roomID");
        let userID=GetQueryString("userID");

        axios.get(`user?userID=`+userID)

            .then(res => { // 请求成功后的处理
                // res是服务器返回的响应数据
                console.log("test");
                console.log(res);
                console.log(res.data);

                const userr = res.data;
                this.setState({ user:userr });
            }).catch(err => { // 请求失败后的处理
            // err是请求失败后的信息
            console.log("erreur");
        })
    }

    render() {
        // @ts-ignore
        // @ts-ignore
        // @ts-ignore
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

    <div>firstName : {this.state.user['firstName']}</div>
    <div>lastName : {this.state.user['lastName']}</div>
    <div>mail : {this.state.user['mail']}</div>

</div>

      </body>
      </html>

  ); }

}

// ReactDOM.createRoot(
//     document.getElementById('testt')
// ).render(<testt />);

export default App;
