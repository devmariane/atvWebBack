package br.edu.ifsp.bra.websocket_queue_chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class MessageDTO {
    private String sender; // Quem enviou (ex: "User1")
    private String recipient; // Quem vai receber (ex: "User2")
    private String content; // Conteúdo do texto
}
