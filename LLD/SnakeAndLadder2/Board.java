package SnakeAndLadder2;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    
    Cell[][] cells;

    public Board(int boardSize, int numberOfLadders, int numberOfSnakes) {
       initializeCells(boardSize);
       addSnakesAndLadders(numberOfLadders, numberOfSnakes);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];

        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                Cell cellobj = new Cell();
                cells[i][j] = cellobj;
            }
        }
    }

    private void addSnakesAndLadders(int numberOfLadders, int numberOfSnakes) {
        //add Ladders

        while(numberOfLadders > 0) {
            int LadderHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length -1);
            int LadderTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            if(LadderHead >= LadderTail) {
                continue;
            }
            Jump ladderObj = new Jump(LadderHead, LadderTail);

            Cell cell = getCell(LadderHead);
            cell.jump = ladderObj;

            //ikkada nenu tail object ni pettavasaram ledu eppudu head ekkada undo ani maatarame e ga check chesedi manam 
            //jumo object lo elago end untadii...no need to update the end point unna cell ...waste of space
            // Cell cell2 = getCell(LadderTail);
            // cell2.jump = ladderObj;

            numberOfLadders--;
        }

        while(numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);

            if(snakeTail >= snakeHead){
                continue;
            }
            Jump snakeObj = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;

            numberOfSnakes--;
        }
    }

    Cell getCell(int number) {
        int row = number/10;
        int col = number%10;

        return cells[row][col];
    }

}
