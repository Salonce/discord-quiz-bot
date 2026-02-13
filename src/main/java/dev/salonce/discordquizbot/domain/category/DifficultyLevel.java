package dev.salonce.discordquizbot.domain.category;

import dev.salonce.discordquizbot.infrastructure.dtos.RawQuestion;
import java.util.List;

public record DifficultyLevel(List<RawQuestion> rawQuestions) {}
