package com.app.pojo;

public class SudokuBoard {

    private long id;
    private final int rows;
    private final int columns;
    private String sudokuBoardAsString;
    private final DifficultyLevel difficultyLevel;

    public SudokuBoard(final DifficultyLevel difficultyLevel, final int rows, final int columns) {
        this.difficultyLevel = difficultyLevel;
        this.rows = rows;
        this.columns = columns;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSudokuBoardAsString(String sudokuBoardAsString) {
        this.sudokuBoardAsString = sudokuBoardAsString;
    }


    public String getSudokuBoardAsString() {
        return sudokuBoardAsString;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }
}
