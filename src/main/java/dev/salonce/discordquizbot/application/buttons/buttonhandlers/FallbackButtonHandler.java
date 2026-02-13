package dev.salonce.discordquizbot.application.buttons.buttonhandlers;

import dev.salonce.discordquizbot.application.buttons.ButtonHandler;
import dev.salonce.discordquizbot.application.ResultStatus;
import dev.salonce.discordquizbot.infrastructure.dtos.ButtonClickRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component("ButtonFallback")
public class FallbackButtonHandler implements ButtonHandler {
    @Override
    // This handler always returns true as it's meant to be the last in the chain
    public Optional<ResultStatus> handle(ButtonClickRequest buttonClickRequest) {
        return Optional.of(ResultStatus.interactionFailed());
    }
}
