package dev.salonce.discordquizbot.infrastructure.dtos;

import discord4j.core.object.entity.channel.MessageChannel;


public record MessageRequest(Long userId,
                             String content,
                             MessageChannel channel) {
}

