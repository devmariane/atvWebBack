package br.edu.ifsp.bra.websocket_queue_chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class PrivateChatController {

    @Autowired
    private SimpMessagingTemplate template;
    // Cliente envia para: /app/chat
    @MessageMapping("chat")
    public void processChatMessage(@Payload MessageDTO message) {
            // 1. Envia para a fila privada do DESTINATÁRIO
            template.convertAndSendToUser(
            message.getRecipient(),
            "/queue/private",
            message
    );
    // 2. Envia para a fila privada do REMETENTE (confirmação na tela)
    template.convertAndSendToUser(
            message.getSender(),
            "/queue/private",
            message
            );
    }
}