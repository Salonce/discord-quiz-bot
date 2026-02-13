package dev.salonce.discordquizbot.infrastructure.mappers;

import dev.salonce.discordquizbot.infrastructure.dtos.MessageRequest;
import discord4j.core.object.entity.Message;
import java.util.Optional;

public class MessageMapper {
    public static Optional<MessageRequest> toDiscordMessage(Message message) {
        return message.getAuthor()
                .map(author -> new MessageRequest(
                        author.getId().asLong(),
                        message.getContent(),
                        message.getChannel().block()
                ));
    }
}
