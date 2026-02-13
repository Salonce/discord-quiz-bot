package dev.salonce.discordquizbot.application.buttons;

import dev.salonce.discordquizbot.application.ResultStatus;
import dev.salonce.discordquizbot.infrastructure.dtos.ButtonClickRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ButtonHandlerChain {
    private final List<ButtonHandler> buttonHandlers;

    public Optional<ResultStatus> handle(ButtonClickRequest buttonClickRequest) {
        for (ButtonHandler handler : buttonHandlers) {
            Optional<ResultStatus> optionalResult = handler.handle(buttonClickRequest);
            if (handler.handle(buttonClickRequest).isPresent()) {
                return optionalResult;
            }
        }
        return Optional.empty();
    }
}
