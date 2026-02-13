package dev.salonce.discordquizbot.infrastructure.dtos;

public record ButtonClickRequest(Long userId,
                                 Long channelId,
                                 String buttonId){
}
