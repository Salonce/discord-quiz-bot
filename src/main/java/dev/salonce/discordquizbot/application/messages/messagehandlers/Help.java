package dev.salonce.discordquizbot.application.messages.messagehandlers;

import dev.salonce.discordquizbot.infrastructure.dtos.MessageRequest;
import dev.salonce.discordquizbot.presentation.messages.HelpMessage;
import dev.salonce.discordquizbot.application.messages.MessageHandler;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component("help")
@RequiredArgsConstructor
public class Help implements MessageHandler {
    private final HelpMessage helpMessage;

    @Override
    public boolean handleMessage(MessageRequest messageRequest) {
        String[] message = messageRequest.content().split(" ");

        if (message[0].equals("qq") && message[1].equals("help")) {
                MessageChannel messageChannel = messageRequest.channel();
                EmbedCreateSpec embed = helpMessage.createEmbed();
                messageChannel.createMessage(embed).subscribe();
                return true;
        }
        return false;
    }
}