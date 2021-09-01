package org.csystem.sample.websockethandler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class UpperServerHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception
    {
        session.sendMessage(new TextMessage("Connection Established"));
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
    {
        var msg = message.getPayload();

        session.sendMessage(new TextMessage("Received Message:" + msg.toUpperCase()));

        if (msg.equals("exit"))
            session.close();

        super.handleTextMessage(session, message);
    }
}
