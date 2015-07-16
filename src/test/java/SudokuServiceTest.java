import com.app.dao.InMemoryStore;
import com.app.exceptions.SudokuException;
import com.app.pojo.DifficultyLevel;
import com.app.pojo.MoveValidator;
import com.app.pojo.SudokuBoard;
import com.app.service.SudokuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {SudokuService.class, InMemoryStore.class})
public class SudokuServiceTest {

    private static final int ROWS = 9;
    private final int COLUMNS = 9;

    @Autowired
    SudokuService sudokuService;

    @Test
    public void testGetSudoku(){
        SudokuBoard board = sudokuService.getSudoku(DifficultyLevel.HARD, ROWS, COLUMNS);
        assertNotNull(board);
        assertEquals(board.getDifficultyLevel(), DifficultyLevel.HARD);
        assertNotNull(board.getId());
        assertNotNull(board.getSudokuBoardAsString());
        assertEquals(board.getSudokuBoardAsString(), sudokuService.getDataStore().getSudoku(board.getId()));
    }

    @Test(expected = SudokuException.class)
    public void testValidateMoveWithNonExistentId() throws SudokuException {
        sudokuService.validateMove(1234, 4, 5, 8);
    }

    @Test
    public void testValidateMove(){
        SudokuBoard boardStub = new SudokuBoard(DifficultyLevel.EASY, ROWS, COLUMNS);
        long id = 8218078219143876788L;
        boardStub.setId(id);
        boardStub.setSudokuBoardAsString("1,0,7,9,0,0,4,0,2,9,4,0,0,0,2,0,0,1,3,0,0,0,0,0,5,0,7,0,0,8,0,0,5,0,9,0,4,2,0,1,9,0,0,0,6,0,1,5,0,6,7,8,4,0,0,0,9,0,2,0,0,3,8,0,7,0,5,3,6,1,0,0,2,6,4,8,0,0,0,0,5");
        sudokuService.getDataStore().addToStore(id, boardStub.getSudokuBoardAsString());
        try {
           assertEquals(MoveValidator.VALID, sudokuService.validateMove(id, 1, 6, 3));
        } catch (SudokuException e) {
            e.printStackTrace();
        }
        String afterMove = "1,0,7,9,0,0,4,0,2,9,4,0,0,0,2,3,0,1,3,0,0,0,0,0,5,0,7,0,0,8,0,0,5,0,9,0,4,2,0,1,9,0,0,0,6,0,1,5,0,6,7,8,4,0,0,0,9,0,2,0,0,3,8,0,7,0,5,3,6,1,0,0,2,6,4,8,0,0,0,0,5";
        assertEquals(afterMove, sudokuService.getDataStore().getSudoku(id));

    }
}
