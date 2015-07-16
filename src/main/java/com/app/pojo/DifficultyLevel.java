package com.app.pojo;

public enum DifficultyLevel {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private final int difficultyLevel;

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    DifficultyLevel(int i) {
        difficultyLevel = i;
    }

}
