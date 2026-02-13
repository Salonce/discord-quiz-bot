package dev.salonce.discordquizbot.domain.answers;

import java.util.Objects;

public record Answer(Integer index) {
    private static final char[] LETTERS = {'A', 'B', 'C', 'D'};

    public Answer {
        if (index != null && (index < 0 || index > 3)) {
            throw new IllegalArgumentException("Index must be 0–3 or null");
        }
    }

    public static Answer fromNumber(int index) {
        return new Answer(index);
    }

    public Integer asNumber() {
        return index;
    }

    public static Answer fromChar(char letter) {
        letter = Character.toUpperCase(letter);
        for (int i = 0; i < LETTERS.length; i++) {
            if (LETTERS[i] == letter) return new Answer(i);
        }
        throw new IllegalArgumentException("Invalid letter: " + letter);
    }

    public static Answer none() { return new Answer(null); }

    public boolean isEmpty() { return index == null; }
    public Character asChar() { return index == null ? null : LETTERS[index]; }
    public boolean isCorrect(Answer correct) { return Objects.equals(this.index, correct.index); }

    @Override
    public String toString() {
        return isEmpty() ? "—" : asChar().toString();
    }
}