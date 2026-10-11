package br.edu.ifsp.bra.websocket_queue_chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Habilita a fila simples para mensagens privadas
        registry.enableSimpleBroker("/queue");
        // Prefixo para métodos anotados com @MessageMapping
        registry.setApplicationDestinationPrefixes("/app");
        // Prefixo para mensagens direcionadas a um usuário (/user)
        registry.setUserDestinationPrefix("/user");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Registra o endpoint /ws com CORS flexível e CustomHandshakeHandler
        registry.addEndpoint("/ws")
            .setAllowedOriginPatterns("*")
            .setHandshakeHandler(new CustomHandshakeHandler())
            .withSockJS();
    }
}