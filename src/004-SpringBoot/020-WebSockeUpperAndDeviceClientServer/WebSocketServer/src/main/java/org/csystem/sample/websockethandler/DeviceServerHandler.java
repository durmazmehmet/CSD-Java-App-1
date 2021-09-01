package org.csystem.sample.websockethandler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.reactive.function.client.WebClient;

public class DeviceServerHandler extends TextWebSocketHandler {
    private WebClient m_webClient = WebClient.create("http://localhost:8080");
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception
    {
        session.sendMessage(new TextMessage("Connection Established for device"));
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
    {
        String msg = "Invalid Id";
        try {
            var id = Long.parseLong(message.getPayload());

            var device = m_webClient.get()
                    .uri("/devicesrest/{id}", id)
                    .exchange().block().bodyToMono(String.class).block();

            if (device != null)
                msg = device;

            if (id == 0)
                session.close();
        }
        catch (Throwable ex) {

        }

        session.sendMessage(new TextMessage(msg));

        super.handleTextMessage(session, message);
    }
}
