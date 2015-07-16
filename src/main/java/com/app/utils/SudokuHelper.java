package com.app.utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuHelper {

    private static final int TOTAL_NUMBERS_FOR_EASY_LEVEL = 40;
    private static final int TOTAL_NUMBERS_FOR_MEDIUM_LEVEL = 32;
    private static final int TOTAL_NUMBERS_FOR_HARD_LEVEL = 25;

    public static String generateRandomNumbersForSudoku(int difficultyLevel, int rows, int columns){
        int totalNumbersNeeded=50;

        switch(difficultyLevel) {
            case 1:  totalNumbersNeeded=TOTAL_NUMBERS_FOR_EASY_LEVEL;break;
            case 2:  totalNumbersNeeded=TOTAL_NUMBERS_FOR_MEDIUM_LEVEL;break;
            case 3:  totalNumbersNeeded=TOTAL_NUMBERS_FOR_HARD_LEVEL;break;
            default :
        }
        int A[][] = new int[rows][columns];
        initializeBoardWithZeroes(A, rows, columns);
        int numbersGenerated=0;
        for(;;) {
            int x = getRandomNumnber(0, rows-1);
            int y = getRandomNumnber(0, columns-1);
            Integer[] arr = {1,2,3,4,5,6,7,8,9};
            List<Integer> list = Arrays.asList(arr);
            Collections.shuffle(list);
            for(int number: list) {
                if (isValidMove(x, y, number, A)) {
                    A[x][y] = number;
                    numbersGenerated++;
                   /* printBoard(A);
                    System.out.println("====================================");*/
                }
            }
            if(numbersGenerated >= totalNumbersNeeded ) break;
        }
        printBoard(A);
        return prepareReturnStringForSudokuBoard(A, rows, columns);
    }

    private static String prepareReturnStringForSudokuBoard(int[][] A, int rows, int columns)
    {
        StringBuilder sb = new StringBuilder();

        for ( byte row = 0; row < rows; row++ ){
            for ( byte col = 0; col < columns; col++ ){
                sb.append(A[row][col]+",");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
        return sb.substring(0, sb.length() - 1);
    }

    private static boolean isValidMove(int x, int y, int number, int[][] a) {
        if(a[x][y] != 0) return false;
        if(doesRowContainSameNumber(x, number, a)) return false;
        if(doesColumnContainSameNumber(y, number, a)) return false;
        if(doesBoxContainSameNumber(x, y, number, a)) return false;
        return true;
    }

    public static boolean doesBoxContainSameNumber(int rowToCheck, int columnToCheck, int numToCheck, int[][] a){
        List<Integer> possibleBoxX = new ArrayList<>(3);
        List<Integer> possibleBoxY = new ArrayList<>(3);
        switch(rowToCheck) {
            case 0:
            case 1:
            case 2: possibleBoxX = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList()); break;
            case 3:
            case 4:
            case 5: possibleBoxX = IntStream.rangeClosed(4, 6).boxed().collect(Collectors.toList()); break;
            case 6:
            case 7:
            case 8: possibleBoxX = IntStream.rangeClosed(7, 9).boxed().collect(Collectors.toList()); break;
        }
        switch(columnToCheck) {
            case 0:
            case 1:
            case 2: possibleBoxY = Arrays.asList(1,4,7); break;
            case 3:
            case 4:
            case 5: possibleBoxY = Arrays.asList(2,5,8); break;
            case 6:
            case 7:
            case 8: possibleBoxY = Arrays.asList(3,6,9); break;
        }
        List<Integer> finalList= new ArrayList<Integer>();
        finalList.addAll(possibleBoxX);
        finalList.retainAll(possibleBoxY);
        int boxNumber= finalList.get(0);
        int[] startCoordinates = getStartCoordinatesOfBox(boxNumber);

        for(int i=startCoordinates[0]; i<=startCoordinates[0]+2; i++)
            for(int j=startCoordinates[1]; j<=startCoordinates[1]+2; j++)
                if (a[i][j] == numToCheck) return true;

        return false;
    }

    public static int[] getStartCoordinatesOfBox(int squareNumber) {
        int[] startCoordinates = null;

        switch (squareNumber) {
            case 1:
                startCoordinates = new int[]{0, 0};
                break;
            case 2:
                startCoordinates = new int[]{0, 3};
                break;
            case 3:
                startCoordinates = new int[]{0, 6};
                break;
            case 4:
                startCoordinates = new int[]{3, 0};
                break;
            case 5:
                startCoordinates = new int[]{3, 3};
                break;
            case 6:
                startCoordinates = new int[]{3, 6};
                break;
            case 7:
                startCoordinates = new int[]{6, 0};
                break;
            case 8:
                startCoordinates = new int[]{6, 3};
                break;
            case 9:
                startCoordinates = new int[]{6, 6};
                break;
        }
        return startCoordinates;
    }

    public static boolean doesRowContainSameNumber(int rowToCheck, int numToCheck, int[][] a)
    {
        for ( int column = 0; column <= 8; column++){
            if ( a[rowToCheck][column] == numToCheck ){
                return true;
            }
        }

        return false;
    }

    public static boolean doesColumnContainSameNumber(int columnToCheck, int numToCheck, int[][] a)
    {
        for ( int row = 0; row <= 8; row++){
            if ( a[row][columnToCheck] == numToCheck ){
                return true;
            }
        }

        return false;
    }

    private static void initializeBoardWithZeroes(int[][] a, int rows, int columns) {
        for(int i=0; i<rows; i++)
            for(int j=0; j<columns; j++)
                a[i][j] = 0;
    }

    public static void printBoard(int[][] a)
    {
        for ( int y = 0; y <=8; y++ ){
            for ( int x = 0; x <=8; x++ ){
                System.out.print(a[y][x] + " ");
                if ( x == 2 || x == 5 ){
                    System.out.print("  ");
                }
            }
            System.out.println();
            if ( y == 2 || y == 5 || y == 8 ){
                System.out.println();
            }
        }
    }

    public static int getRandomNumnber(int min, int max) {
        Random rand = new Random();
        return  rand.nextInt((max - min) + 1) + min;
    }

    public static void main(String v[]){
        generateRandomNumbersForSudoku(1, 9, 9);
    }
}
