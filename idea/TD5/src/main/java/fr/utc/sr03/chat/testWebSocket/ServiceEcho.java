package fr.utc.sr03.chat.testWebSocket;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.OnError;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpointConfig;


@ServerEndpoint("/echo")

public class ServiceEcho {
     @OnMessage
     public String echo(String message){
        return "Merci pour ton message : " + message;
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println( "Error: " + error.getMessage() );
    }

}



