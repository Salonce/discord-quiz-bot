package dev.salonce.discordquizbot.domain.scores;

import java.util.ArrayList;
import java.util.List;

public record RankGroup(int rank, int points, List<Long> playerIds) {
    public RankGroup(int rank, int points, List<Long> playerIds) {
        this.rank = rank;
        this.points = points;
        this.playerIds = List.copyOf(playerIds); // immutable
    }

    @Override
    public List<Long> playerIds() {
        return playerIds;
    }

    public boolean containsPlayer(Long playerId) {
        return playerIds.contains(playerId);
    }
}
