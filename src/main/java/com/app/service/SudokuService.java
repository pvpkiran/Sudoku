package com.app.service;

import com.app.pojo.DifficultyLevel;
import com.app.pojo.MoveValidator;
import com.app.pojo.SudokuBoard;
import org.springframework.stereotype.Service;

@Service
public class SudokuService {

    public SudokuBoard getSudoku(DifficultyLevel difficultyLevel, int rows, int columns) {
        return null;
    }

    public MoveValidator validateMove(int x, int y, int number) {
        return null;
    }
}
