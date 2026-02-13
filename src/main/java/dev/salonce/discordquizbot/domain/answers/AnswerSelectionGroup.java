package dev.salonce.discordquizbot.domain.answers;

import java.util.*;

import java.util.Collections;
import java.util.List;

public record AnswerSelectionGroup(
        List<Long> userIds,
        Answer answer,
        Boolean isCorrect
) {
    public AnswerSelectionGroup {
        userIds = List.copyOf(userIds); // defensive copy for immutability
        Objects.requireNonNull(answer, "Answer cannot be null");
        Objects.requireNonNull(isCorrect, "isCorrect cannot be null");
    }
}