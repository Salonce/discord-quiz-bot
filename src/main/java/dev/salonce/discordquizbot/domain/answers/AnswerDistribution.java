package dev.salonce.discordquizbot.domain.answers;

import java.util.List;
import java.util.Objects;

public record AnswerDistribution(List<AnswerSelectionGroup> selectedAnswersGroups,
                                 AnswerSelectionGroup unselectedAnswerGroup, Answer correctAnswer, int totalOptions) {

    public AnswerDistribution(List<AnswerSelectionGroup> selectedAnswersGroups,
                              AnswerSelectionGroup unselectedAnswerGroup,
                              Answer correctAnswer,
                              int totalOptions) {
        this.selectedAnswersGroups = List.copyOf(selectedAnswersGroups);
        this.unselectedAnswerGroup = Objects.requireNonNull(unselectedAnswerGroup);
        this.correctAnswer = Objects.requireNonNull(correctAnswer);
        this.totalOptions = totalOptions;
    }
}