package dev.salonce.discordquizbot.domain.questions;

import dev.salonce.discordquizbot.domain.answers.Answer;

import java.util.*;

public record Question(String question, List<Option> options, String explanation) {

    public boolean isCorrectAnswer(Answer answer) {
        if (answer.isEmpty()) return false;
        return (options.get(answer.asNumber()).isCorrect());
    }

    public Answer getCorrectAnswer() {
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isCorrect())
                return Answer.fromNumber(i);
        }
        return Answer.none();
    }

    public List<Answer> getPossibleAnswers() {
        List<Answer> answers = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            answers.add(Answer.fromNumber(i));
        }
        return answers;
    }
}
