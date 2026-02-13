package dev.salonce.discordquizbot.application.buttons.buttonhandlers;

import dev.salonce.discordquizbot.application.MatchService;
import dev.salonce.discordquizbot.application.buttons.ButtonHandler;
import dev.salonce.discordquizbot.application.ResultStatus;
import dev.salonce.discordquizbot.domain.answers.Answer;
import dev.salonce.discordquizbot.infrastructure.dtos.ButtonClickRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.lang.Integer.parseInt;

@RequiredArgsConstructor
@Component("ButtonAnswer")
public class AnswerButtonHandler implements ButtonHandler {

    private final MatchService matchService;

    @Override
    public Optional<ResultStatus> handle(ButtonClickRequest buttonClickRequest) {
        String buttonId = buttonClickRequest.buttonId();
        if (!buttonId.startsWith("Answer") || !buttonId.matches("Answer-[A-D]-\\d+"))
            return Optional.empty();

        String[] answerData = buttonId.split("-");
        int questionNumber = Integer.parseInt(answerData[2]);
        Answer answer = Answer.fromChar(answerData[1].charAt(0));

        return Optional.of(matchService.addPlayerAnswer(buttonClickRequest.channelId(), buttonClickRequest.userId(), questionNumber, answer));
    }
}
