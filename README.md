# Sudoku

This is a Sudoku web service which can generate a random sudoku board of 9X9 with the given difficulty level.
 Available Difficulty Levels are Easy(1), Medium(2), Hard(3).
 By default the webservice runs on port 8080.

1. To generate a sudoku board issue a GET request on 

        http://<server>:<port>/getboard/<Difficulty level>/<rows>/<columns>
        
   This returns an Object with the following fields   
              - **id**: unique long id associated with the board,   
              - **sudokuBoardAsString**: Sudoku board as String(With blank spaces indicated by 0)
                   
    Example : `http://localhost:8080/getboard/1/9/9` 
    
    Output  : {"id" : 8218078219143876788,      
               "sudokuBoardAsString" : "1,0,0,0,6,9,0,3,0,2,4,0,0,0,1,6,0,7,0,0,5,0,0,0,8,2,0,6,1,4,0,2,0,5,9,0,0,0,0,8,0,0,0,7,0,9,2,8,5,1,0,0,6,0,0,0,9,1,7,0,0,8,4,0,5,6,0,3,0,2,1,0,0,7,3,0,0,6,0,5,0",
                }
                
  This is similar to
 ```
             1 0 0   0 6 9   0 3 0
             2 4 0   0 0 1   6 0 7
             0 0 5   0 0 0   8 2 0    
             
             6 1 4   0 2 0   5 9 0
             0 0 0   8 0 0   0 7 0
             9 2 8   5 1 0   0 6 0    
             
             0 0 9   1 7 0   0 8 4
             0 5 6   0 3 0   2 1 0
             0 7 3   0 0 6   0 5 0
 ```
         

2. To make a move on a given sudoku board issue a POST request on    
            
        http://<server>:<port>/validatemove?id=<returned_id_from_getboard>&x=<x-coordinate>&y=<y-coordinate>&number=<number_to_be_inserted>
   
      Example : `http://localhost:8080/validatemove?id=888895882976226&x=1&y=3&number=7`
   This returns   
   
      - **Exception** : If the given id is invalid
      - **VALID**     : If the move is Valid
      - **INVALID**   : If the move is Invalid
      - **COMPLETE**  : If the board is completed
