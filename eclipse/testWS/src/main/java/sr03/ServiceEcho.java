package sr03;

import jakarta.websocket.OnMessage;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class ServiceEcho {
     @OnMessage
     public String echo(String message){
        return "Merci pour ton message : " + message;
    }
}
