package TicTacToe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String  player1Symbol = scanner.next();
        String  player1name = scanner.next();
        String  player2Symbol = scanner.next();
        String  player2name = scanner.next();
        System.out.println(player1name + " - " + player1Symbol);
        System.out.println(player2name + " - " + player2Symbol);
        TBoard tBoard=new TBoard(3);
        tBoard.displayBoard();
        String playername=player1name;
        String playersymbol=player1Symbol;
        while (true){
            int row=scanner.nextInt()-1;
            int column=scanner.nextInt()-1;
            if(tBoard.board[row][column].equals("-")){
            tBoard.board[row][column]=playersymbol;
            tBoard.displayBoard();
            if(tBoard.playerWon(row,column,playersymbol)){
                System.out.println(playername+ " has won ");
                break;
            }
            if(playername.equals(player1name)){
                playername=player2name;
                playersymbol=player2Symbol;
            }
            else
            {
                playername=player1name;
                playersymbol=player1Symbol;
            }}
            else{
                System.out.println("invalid move");
            }
        }
    }
}
/*
X Gaurav
O Sagar
2 2
1 3
1 1
1 2
2 2
3 3
exit

- - -
- - -
- - -
- - -
- X -
- - -
- - O
- X -
- - -
X - O
- X -
- - -
X O O
- X -
- - -
Invalid Move
X O O
- X -
- - X
Gaurav won the game


2 3
1 2
2 2
2 1
1 1
3 3
3 2
3 1
1 3
 */
