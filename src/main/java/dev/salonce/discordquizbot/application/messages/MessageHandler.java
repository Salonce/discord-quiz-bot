package dev.salonce.discordquizbot.application.messages;

import dev.salonce.discordquizbot.infrastructure.dtos.MessageRequest;

public interface MessageHandler {
    boolean handleMessage(MessageRequest messageRequest);
}
