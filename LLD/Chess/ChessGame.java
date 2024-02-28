package Chess;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {
    int player1=1;
    int player2=2;
    Board board=new Board();
    int currentTurn;
    boolean isWhite;
    List<Move> moveList=new ArrayList<Move>();

    public ChessGame(){
        board.resetBoard();
        currentTurn=player1;
        isWhite=true;
    }


    public void playerMoves(int sx, int sy, int dx, int dy, Boolean gameOver) {
           Box srcBox=board.box[sx][sy];
           if((srcBox.piece == null) || (srcBox.piece.isWhite != isWhite)) {
               System.out.println("InvalidMove as no piece is present at source position or current-player color and src piece color are not same");
           }
           if(srcBox.piece.canMove(sx,sy,dx,dy)){
               Piece destPiece=board.box[dx][dy].piece;
               if((destPiece!=null)&&(destPiece.isWhite==srcBox.piece.isWhite)){
                   System.out.println("InvalidMove as source and dest pieces are of same color ");
               }
               Move move=new Move(sx,sy,dx,dy,srcBox.piece);
               moveList.add(move);
               if((destPiece!=null)&&destPiece.isKing){
                   System.out.println("gameover "+currentTurn+" has won the game");
                   gameOver=true;
                   for(Move m:moveList){
                       System.out.println(sx+" "+sy+" "+dx+" "+dy+" "+m.piece);
                   }
               }
               board.box[dx][dy].piece=srcBox.piece;
               board.box[dx][dy].isOccupied=true;
               board.box[sx][sy].piece=null;
               board.box[dx][dy].isOccupied=false;
               //board.displayBoard();
               isWhite=!isWhite;
               if(currentTurn==player1){
                   currentTurn=player2;
               }
               else{
                   currentTurn=player1;
               }
           }
    }
}
