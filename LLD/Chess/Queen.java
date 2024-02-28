package Chess;

import static java.lang.Math.abs;

public class Queen extends Piece{
    public Queen(boolean isKilled, boolean isWhite) {
        super(isKilled, isWhite);
    }

    public boolean canMove(int sX,int sY,int dX,int dY) {
        int X=abs(dX-sX);
        int Y=abs(dY-sY);
        if(X==Y||(X==0&&Y!=0)||(Y==0&&X!=0)||!(X==0&&Y==0))
            return true;
        else
            return false;
    }
}
