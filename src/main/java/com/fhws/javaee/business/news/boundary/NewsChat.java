/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fhws.javaee.business.news.boundary;

import com.fhws.javaee.business.appuser.boundary.CurrentUser;
import com.fhws.javaee.business.appuser.entity.AppUser;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@Singleton
@ServerEndpoint("/chat")
public class NewsChat {

    private final Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

  
    @OnMessage
    public void incomingMsg(String message, Session session) throws IOException {
        String sendMessage = "Sender: " + session.getId() + " -> " + message;
        broadCastMessage(sendMessage);
    }

    void broadCastMessage(String message) throws IOException {
        for (Session s : clients) {
            s.getBasicRemote().sendText(message);
        }
    }

    @OnOpen
    public void open(Session session) {
        System.out.println("new WebSocket session " + session.getId());
        clients.add(session);
    }

    @OnClose
    public void close(Session session) {
        clients.remove(session);
    }

    public void newLogin(@Observes @NewsLogin String message) throws IOException {
        broadCastMessage(message);
    }
}
