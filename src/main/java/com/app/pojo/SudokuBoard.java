package com.app.pojo;

public class SudokuBoard {

   private final int rows;
    private final int columns;
    private String sudokuBoardAsString;
    private final DifficultyLevel difficultyLevel;

    public SudokuBoard(final DifficultyLevel difficultyLevel, final int rows, final int columns) {
        this.difficultyLevel = difficultyLevel;
        this.rows = rows;
        this.columns = columns;
    }
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
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
