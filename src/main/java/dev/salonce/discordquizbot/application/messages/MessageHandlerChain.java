package dev.salonce.discordquizbot.application.messages;

import dev.salonce.discordquizbot.infrastructure.dtos.MessageRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MessageHandlerChain {
    private final List<MessageHandler> messageHandlers;

    public void handle(MessageRequest messageRequest){
        for (MessageHandler messageHandler : messageHandlers) {
            if (messageHandler.handleMessage(messageRequest))
                break;
        }
    }
}
