package com.app.controller;

import com.app.exceptions.SudokuException;
import com.app.pojo.DifficultyLevel;
import com.app.pojo.MoveValidator;
import com.app.pojo.SudokuBoard;
import com.app.service.SudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;

@RestController
public class SudokuController {

    @Autowired
    SudokuService sudokuService;

    @RequestMapping("/")
    public String welcomeScreen() {
        return "Welcome to Sudoku validator";
    }

    @RequestMapping(value = "/getboard/{difficultyLevel}/{rows}/{columns}", method = RequestMethod.GET)
    public SudokuBoard getBoard(@PathVariable DifficultyLevel difficultyLevel,
                                @PathVariable int rows,
                                @PathVariable int columns){

        return sudokuService.getSudoku(difficultyLevel, rows, columns);
    }

    @RequestMapping(value ="/validatemove", method = RequestMethod.POST)
    public MoveValidator validateMove(@QueryParam("id")long id,
                                      @QueryParam("x")int x,
                                      @QueryParam("x")int y,
                                      @QueryParam("number")int number) throws SudokuException {


        return sudokuService.validateMove(id, x, y, number);
    }

    @ExceptionHandler(SudokuException.class)
    public ModelAndView handleException(HttpServletRequest req, SudokuException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}

