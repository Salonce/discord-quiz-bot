package dev.salonce.discordquizbot.domain.players;

import dev.salonce.discordquizbot.domain.answers.Answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Player {

    private final List<Answer> answersList;
    public Player(int answersSize) {
        this.answersList = new ArrayList<>(Collections.nCopies(answersSize, Answer.none()));
    }
    public Answer getAnswer(int index){
        return answersList.get(index);
    }
    public void setAnswer(int index, Answer answer){
        this.answersList.set(index, answer);
    };
    public boolean isUnanswered(int index){
        return (answersList.get(index).isEmpty());
    }

    //edited
    public int calculateScore(List<Answer> correctAnswers) {
        return (int) IntStream.range(0, correctAnswers.size())
                .filter(i -> answersList.get(i).equals(correctAnswers.get(i)))
                .count();
    }
}