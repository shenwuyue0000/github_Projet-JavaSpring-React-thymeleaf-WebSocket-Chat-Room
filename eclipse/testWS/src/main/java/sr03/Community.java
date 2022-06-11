package sr03;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import jakarta.websocket.*;

import org.apache.catalina.core.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
//import lombok.extern.log4j.Log4j;
 
/**
 * Create by Wzy
 * on 2018/8/6 13:24
 * 不短不长八字刚好
 */
@ServerEndpoint("/community/{ro_user}")

public class Community {
 
 
    private static final Map<Integer, CopyOnWriteArraySet<Community>> rooms = new HashMap<>();
 
    private Session session;
 
    private Integer userId;
 
    private Integer roomId;
 
    @OnOpen
    public void onOpen(@PathParam(value = "ro_user") String ro_user, Session session) {
        this.session = session;
        String[] param = ro_user.split("-");
        this.roomId = Integer.parseInt(param[0]);
        this.userId = Integer.parseInt(param[1]);
        CopyOnWriteArraySet<Community> friends = rooms.get(roomId);
        if (friends == null) {
            synchronized (rooms) {
                if (!rooms.containsKey(roomId)) {
                    friends = new CopyOnWriteArraySet<>();
                    rooms.put(roomId, friends);
                }
            }
        }
        friends.add(this);
        
        sendMessage( "Admin >>> Connection established for " + userId );   ////
    }
 
    @OnClose
    public void onClose() {
        CopyOnWriteArraySet<Community> friends = rooms.get(roomId);
        if (friends != null) {
            friends.remove(this);
        }
        sendMessage( "Admin >>> Connection closed for " + userId ); ///
    }
 
    @OnMessage
    public void onMessage(final String message, Session session) {
        
 
 
        CopyOnWriteArraySet<Community> friends = rooms.get(roomId);
        if (friends != null) {
            for (Community item : friends) {
                item.session.getAsyncRemote().sendText(userId+" >>> "+message);
            }
        }
    }
 
    @OnError
    public void onError(Session session, Throwable error) {
      
        error.printStackTrace();
    }
    
    
    private void sendMessage( String fullMessage ) {
        // Affichage sur la console du server Web.
        System.out.println( fullMessage );      
        
        // On envoie le message � tout le monde.
        CopyOnWriteArraySet<Community> friends = rooms.get(roomId);
        if (friends != null) {
            for (Community item : friends) {
                item.session.getAsyncRemote().sendText(fullMessage);
            }
        }
        
        
    }
}

