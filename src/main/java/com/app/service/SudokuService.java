package com.app.service;

import com.app.dao.DataStore;
import com.app.exceptions.SudokuException;
import com.app.pojo.DifficultyLevel;
import com.app.pojo.MoveValidator;
import com.app.pojo.SudokuBoard;
import com.app.utils.SudokuHelper;
import com.app.utils.UniqueIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SudokuService {

    @Autowired
    DataStore dataStore;

    public DataStore getDataStore() {
        return dataStore;
    }
    public SudokuBoard getSudoku(DifficultyLevel difficultyLevel, int rows, int columns) {
        SudokuBoard board = new SudokuBoard(difficultyLevel, rows, columns);
        board.setSudokuBoardAsString(
                SudokuHelper.generateRandomNumbersForSudoku(
                        board.getDifficultyLevel().getDifficultyLevel(), board.getRows(), board.getColumns()));
        board.setId(UniqueIdGenerator.getUniqueLongId());
        dataStore.addToStore(board.getId(), board.getSudokuBoardAsString());
        return board;
    }

    public MoveValidator validateMove(long id, int x, int y, int number) throws SudokuException {
        String sudokuBoardAsString =  dataStore.getSudoku(id);
        if(sudokuBoardAsString == null) throw new SudokuException("Sudoku with given id doesn't exist.");
        MoveValidator result = SudokuHelper.isValidMove(x, y, number, sudokuBoardAsString);
        if(result.equals(MoveValidator.VALID))
            dataStore.addToStore(id, SudokuHelper.updateMove(x, y, number, sudokuBoardAsString));

        return result;
    }
}
