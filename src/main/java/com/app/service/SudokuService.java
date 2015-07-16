package com.app.service;

import com.app.pojo.DifficultyLevel;
import com.app.pojo.MoveValidator;
import com.app.pojo.SudokuBoard;
import com.app.utils.SudokuHelper;
import org.springframework.stereotype.Service;

@Service
public class SudokuService {

    public SudokuBoard getSudoku(DifficultyLevel difficultyLevel, int rows, int columns) {
        SudokuBoard board = new SudokuBoard(difficultyLevel, rows, columns);
        board.setSudokuBoardAsString(
                SudokuHelper.generateRandomNumbersForSudoku(
                        board.getDifficultyLevel().getDifficultyLevel(), board.getRows(), board.getColumns()));
        return board;
    }

    public MoveValidator validateMove(int x, int y, int number) {
        return null;
    }
}
