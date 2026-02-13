package dev.salonce.discordquizbot.domain.category;

import java.util.List;

public record Category(String name, List<DifficultyLevel> difficulties) {
    public Category(String name, List<DifficultyLevel> difficulties) {
        this.name = name;
        this.difficulties = List.copyOf(difficulties); // immutable copy
    }

    public boolean difficultyLevelExists(int level) { return difficulties.size() >= level;}
    public DifficultyLevel getDifficultyLevel(int level) {return difficulties.get(level - 1);}
    public int getMaxDifficultyLevelAsInt() { return difficulties.size();}
}