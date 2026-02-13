package dev.salonce.discordquizbot.application.buttons.buttonhandlers;

import dev.salonce.discordquizbot.application.buttons.ButtonHandler;
import dev.salonce.discordquizbot.application.ResultStatus;
import dev.salonce.discordquizbot.infrastructure.dtos.ButtonClickRequest;
import dev.salonce.discordquizbot.application.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component("ButtonJoinMatch")
public class JoinMatchButtonHandler implements ButtonHandler {

    private final MatchService matchService;

    @Override
    public Optional<ResultStatus> handle(ButtonClickRequest data) {
        if (!"joinQuiz".equals(data.buttonId()))
            return Optional.empty();
        return Optional.of(matchService.addPlayerToMatch(data.channelId(), data.userId()));
    }
}
