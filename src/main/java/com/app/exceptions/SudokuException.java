package com.app.exceptions;

public class SudokuException extends Exception{
    private final String message;

    public SudokuException(final String message){
        this.message = message;
    }

    public String toString(){
        return "Error : "+ message;
    }
}
