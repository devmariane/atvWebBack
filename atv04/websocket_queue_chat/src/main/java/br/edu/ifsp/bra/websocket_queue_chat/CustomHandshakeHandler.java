package br.edu.ifsp.bra.websocket_queue_chat;

import java.security.Principal;
import java.util.Map;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.web.util.UriComponentsBuilder;

public class CustomHandshakeHandler extends DefaultHandshakeHandler {
    @Override
    protected Principal determineUser(ServerHttpRequest request,
                        WebSocketHandler wsHandler,
                        Map<String, Object> attributes) {
        // Extrai o parâmetro ?username= da URL de conexão
        String username = UriComponentsBuilder.fromUri(request.getURI())
                        .build()
                        .getQueryParams()
                        .getFirst("username");
        // Associa o Principal ao nome recebido ou gera ID genérico
        return () -> (username != null && !username.isBlank()
                        ? username
                        : "User_" + System.currentTimeMillis());
    }
}