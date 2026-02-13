package dev.salonce.discordquizbot.domain.players;

import dev.salonce.discordquizbot.domain.answers.Answer;
import dev.salonce.discordquizbot.domain.answers.AnswerSelectionGroup;
import dev.salonce.discordquizbot.domain.UserAlreadyJoined;
import dev.salonce.discordquizbot.domain.scores.PlayerScore;

import java.util.*;
import java.util.stream.Collectors;

public class Players {

    private final Map<Long, Player> players;

    public Players(){
        this.players = new HashMap<>();
    }

    public void add(Long userId, int answersSize) {
        if (players.containsKey(userId))
            throw new UserAlreadyJoined();
        players.put(userId, new Player(answersSize));
    }

    public boolean exists(Long userId){
        return players.containsKey(userId);
    }

    public Iterator<Long> getPlayersIdsIterator(){
        return players.keySet().iterator();
    }

    public List<Long> getPlayersIds(){
        return players.keySet().stream().toList();
    }

    public Long getOwnerId(){
        try { return players.keySet().iterator().next(); }
        catch (NoSuchElementException e){ return null; }
    }

    public void setPlayerAnswer(Long userId, int questionIndex, Answer answer){
        players.get(userId).setAnswer(questionIndex, answer);
    }

    public void removePlayer(Long userId){
        players.remove(userId);
    }

    public boolean nooneAnswered(int index) {
        return players.values().stream()
                .allMatch(player -> player.isUnanswered(index));
    }

    public boolean everyoneAnswered(int index){
        for (Player player : players.values()){
            if (player.isUnanswered(index))
                return false;
        }
        return true;
    }

    public AnswerSelectionGroup getAnswerGroup(int questionIndex, Answer answer, boolean isCorrect) {
        List<Long> userIds = new ArrayList<>();

        players.forEach((playerId, player) -> {
            if (player.getAnswer(questionIndex).equals(answer))
                userIds.add(playerId);
        });
        return new AnswerSelectionGroup(userIds, answer, isCorrect);
    }

    public List<PlayerScore> calculateScores(List<Answer> correctAnswers) {
        return players.entrySet().stream()
                .map(e -> new PlayerScore(
                        e.getKey(),
                        e.getValue().calculateScore(correctAnswers)
                ))
                .toList();
    }
}
