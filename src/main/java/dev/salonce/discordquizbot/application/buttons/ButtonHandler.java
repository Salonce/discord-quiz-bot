package dev.salonce.discordquizbot.application.buttons;

import dev.salonce.discordquizbot.application.ResultStatus;
import dev.salonce.discordquizbot.infrastructure.dtos.ButtonClickRequest;

import java.util.Optional;

public interface ButtonHandler {
    Optional<ResultStatus> handle(ButtonClickRequest buttonClickRequest);
}
