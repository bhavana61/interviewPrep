package SnakeAndLadder2;


import java.util.Deque;
import java.util.LinkedList;

public class SnakeAndLadder2 {
    Board board;
    Deque<Player> players = new LinkedList<>();
    Dice dice;
    Player winner;

    public SnakeAndLadder2() {
       initializeGame();
    }

    public void initializeGame() {

        board = new Board(10, 4, 5);
        dice = new Dice(1);
        addPlayers();
        winner = null;
    }

    public void addPlayers() {
        Player player1 = new Player("1", 0);
        Player player2 = new Player("2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while(winner == null) {
            //check whose turn it is now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is " + playerTurn.id +" and its current position is:" + playerTurn.currentPosition);

            //roll the dice
            int diceNumbers = dice.roll();

            //get the new position
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println(playerTurn.id + "'s new position is: " + playerTurn.currentPosition);

            //check for winning condition this to be considered from he requiremens what is the bhsiness rule for winning
            //currently i am considering if a player crosses 99 he wins 
            if(playerNewPosition >= board.cells.length*board.cells.length -1) {
                winner = playerTurn;
            }
        }
        System.out.println("WINNER IS : "+ winner.id);
    }

    private Player findPlayerTurn() {
        Player currPlayer = players.removeFirst();
        players.addLast(currPlayer);

        return currPlayer;
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition > board.cells.length*board.cells.length -1) {
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
           
            String jumpBy = (cell.jump.start > cell.jump.end)? "Snake" :"Ladder";
            System.out.println("jump done by" + jumpBy);
            playerNewPosition = cell.jump.end;
        }

        return playerNewPosition;
    }

}
