import axios from "axios";

window.addEventListener( "load", function( event ) {

    function GetQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return unescape(r[2]); return null;
    }
    //GetQueryString("pseudo");


    //let pseudo = prompt( "Veuillez saisir votre pseudo :" );
    let pseudo=GetQueryString("pseudo");
    let roomID=GetQueryString("roomID");
    let userID=GetQueryString("userID");
    //let ws = new WebSocket( "ws://localhost:8081/testWS/chatserver/" + pseudo );
    let ws = new WebSocket( "ws://localhost:8081/testWS/community/" + roomID+"-"+userID );

    let txtHistory = document.getElementById( "history" );
    let txtMessage = document.getElementById( "txtMessage" );
    txtMessage.focus();


    ws.addEventListener( "open", function( evt ) {
        console.log( "Connection established" );
    });

    ws.addEventListener( "message", function( evt ) {
        let message = evt.data;
        console.log( "Receive new message: " + message );
        txtHistory.value += message + "\n";
    });

    ws.addEventListener( "close", function( evt ) {
        console.log( "Connection closed" );
    });


    let btnSend = document.getElementById( "btnSend" );
    btnSend.addEventListener( "click", function( clickEvent ) {
        ws.send( txtMessage.value );
        txtMessage.value = "";
        txtMessage.focus();
    });

    let btnClose = document.getElementById( "btnClose" );
    btnClose.addEventListener( "click", function( clickEvent ) {
        ws.close();
    });

});