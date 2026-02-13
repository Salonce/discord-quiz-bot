package dev.salonce.discordquizbot.application.buttons.buttonhandlers;

import dev.salonce.discordquizbot.application.buttons.ButtonHandler;
import dev.salonce.discordquizbot.application.ResultStatus;
import dev.salonce.discordquizbot.infrastructure.dtos.ButtonClickRequest;
import dev.salonce.discordquizbot.application.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@RequiredArgsConstructor
@Component("ButtonLeaveMatch")
public class LeaveMatchButtonHandler implements ButtonHandler {

    private final MatchService matchService;

    @Override
    public Optional<ResultStatus> handle(ButtonClickRequest buttonClickRequest) {
        if (!"leaveQuiz".equals(buttonClickRequest.buttonId()))
            return Optional.empty();
        return Optional.of(matchService.removeUserFromMatch(buttonClickRequest.channelId(), buttonClickRequest.userId()));
    }
}