import com.app.pojo.MoveValidator;
import com.app.utils.SudokuHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SudokuHelperTest {

    @Test
    public void testBoardCreation(){
        String sudokuBoardAsAtring = SudokuHelper.generateRandomNumbersForSudoku(1, 9, 9);
        int toltalGeneratedNumbers=0;
        for(int i=0; i<sudokuBoardAsAtring.length(); i++){
            if(sudokuBoardAsAtring.charAt(i)!= ',' && sudokuBoardAsAtring.charAt(i)!= '0')
                toltalGeneratedNumbers++;
        }
        assertTrue("Number of solved numbers for Easy level should be 40", toltalGeneratedNumbers==40);
    }

    @Test
    public void testBoardCreatedIsValid(){
        String generatedSudokuBoardAsString = "1,0,7,9,0,0,4,0,2,9,4,0,0,0,2,0,0,1,3,0,0,0,0,0,5,0,7,0,0,8,0,0,5,0,9,0,4,2,0,1,9,0,0,0,6,0,1,5,0,6,7,8,4,0,0,0,9,0,2,0,0,3,8,0,7,0,5,3,6,1,0,0,2,6,4,8,0,0,0,0,5";
        int row = 1;
        int column = 5;
        int number = 2;
        generatedSudokuBoardAsString = generatedSudokuBoardAsString.replaceAll(",", "");
        int A[][] = SudokuHelper.convertStringTo2DArray(generatedSudokuBoardAsString, 9, 9);
        assertTrue(SudokuHelper.doesRowContainSameNumber(row, number, A));
        assertTrue(SudokuHelper.doesColumnContainSameNumber(column, number, A));
        assertTrue(SudokuHelper.doesBoxContainSameNumber(row, column, number, A));
    }

    @Test
    public void testIfMoveIsValid(){
        String generatedSudokuBoardAsString = "1,0,7,9,0,0,4,0,2,9,4,0,0,0,2,0,0,1,3,0,0,0,0,0,5,0,7,0,0,8,0,0,5,0,9,0,4,2,0,1,9,0,0,0,6,0,1,5,0,6,7,8,4,0,0,0,9,0,2,0,0,3,8,0,7,0,5,3,6,1,0,0,2,6,4,8,0,0,0,0,5";
        assertEquals(SudokuHelper.isValidMove(1, 6, 3, generatedSudokuBoardAsString), MoveValidator.VALID);
        assertEquals(SudokuHelper.isValidMove(1, 6, 1, generatedSudokuBoardAsString), MoveValidator.INVALID);
        String solvedSudokuString = "4,3,6,9,7,1,8,2,5,7,1,9,5,2,8,6,4,3,8,5,2,4,6,3,9,1,7,6,4,7,1,8,5,2,3,9,1,8,3,2,9,7,5,6,4,9,2,5,3,4,6,1,7,8,5,6,8,7,1,4,3,9,2,3,9,4,6,5,2,7,8,1,2,7,1,8,3,9,4,5,6";
        assertEquals(SudokuHelper.isValidMove(1, 6, 1, solvedSudokuString), MoveValidator.COMPLETE);
    }
}
