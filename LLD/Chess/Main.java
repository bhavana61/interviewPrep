package Chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ChessGame chessGame=new ChessGame();
        Scanner scanner = new Scanner(System.in);
        Boolean gameOver=false;
        while(!gameOver){
            int Sx=scanner.nextInt()-1;
            int Sy=scanner.nextInt()-1;
            int Dx=scanner.nextInt()-1;
            int Dy=scanner.nextInt()-1;
            chessGame.playerMoves(Sx,Sy,Dx,Dy,gameOver);
        }
    }
}
/*
2 5 3 5
7 5 6 5
1 6 4 3
8 2 6 3
1 4 5 8
8 7 6 6
5 8 7 6
8 6 7 6
7 7 7 6
8 8 7 6
a=1,b=2,c=3,d=4,e=5,f=6,g=7,h=8
e2 e4
e7 e5
f1 c4
b8 c6
d1 h5
g8 f6
h5 f7
f8 f7
g7 f7
h8 f7

d8 f7
c6 f7
c4 f7
h8 g8
f2 f4
e5 f4
f7 e8
 */
