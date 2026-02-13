package dev.salonce.discordquizbot.domain.scores;

import java.util.Objects;

public record PlayerScore(Long playerId, int points) {}
