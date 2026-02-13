package dev.salonce.discordquizbot.domain.scores;

import java.util.*;
import java.util.stream.Collectors;

public class Scoreboard {
    private final List<PlayerScore> playerScoresRanked;
    private final List<RankGroup> rankGroups;

    public Scoreboard(List<PlayerScore> scores) {
        // Sort by points descending, then by playerId for consistency
        this.playerScoresRanked = scores.stream()
                .sorted(Comparator.comparing(PlayerScore::points).reversed()
                        .thenComparing(PlayerScore::playerId))
                .collect(Collectors.toList());

        this.rankGroups = calculateRankGroups();
    }

    private List<RankGroup> calculateRankGroups() {
        if (playerScoresRanked.isEmpty()) {
            return Collections.emptyList();
        }

        List<RankGroup> groups = new ArrayList<>();
        int currentRank = 1;

        // Group players by points while maintaining rank order
        Map<Integer, List<Long>> pointsToPlayers = new LinkedHashMap<>();

        for (PlayerScore score : playerScoresRanked) {
            pointsToPlayers.computeIfAbsent(score.points(), k -> new ArrayList<>())
                    .add(score.playerId());
        }

        // Convert to RankGroups with proper ranking
        for (Map.Entry<Integer, List<Long>> entry : pointsToPlayers.entrySet()) {
            int points = entry.getKey();
            List<Long> playerIds = entry.getValue();

            groups.add(new RankGroup(currentRank, points, playerIds));
            currentRank += playerIds.size(); // Next rank accounts for ties
        }

        return groups;
    }

    public List<PlayerScore> getPlayerScoresRanked() {
        return new ArrayList<>(playerScoresRanked); // Unnecessary copy!
    }

    public List<RankGroup> getRankGroups() {
        return new ArrayList<>(rankGroups);
    }
}
