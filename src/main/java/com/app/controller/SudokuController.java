package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SudokuController {

    @RequestMapping("/")
    public String welcomeScreen() {
        return "Welcome to Sudoku validator";
    }
}

