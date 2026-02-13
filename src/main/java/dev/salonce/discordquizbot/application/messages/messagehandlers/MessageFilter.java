package dev.salonce.discordquizbot.application.messages.messagehandlers;

import dev.salonce.discordquizbot.infrastructure.dtos.MessageRequest;
import dev.salonce.discordquizbot.application.messages.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component("messageFilter")
@RequiredArgsConstructor
public class MessageFilter implements MessageHandler {

    @Override
    public boolean handleMessage(MessageRequest messageRequest){

        String content = messageRequest.content();

        if (content == null || content.isEmpty()) return true;
        if (!content.startsWith("qq")) return true;
        if (content.length() > 50)  return true;

        String[] message = messageRequest.content().split(" ");
        return message.length < 2 || message.length > 6;
    }
}