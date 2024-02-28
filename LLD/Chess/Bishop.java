package Chess;

import static java.lang.Math.abs;

public class Bishop extends Piece{
    public Bishop(boolean isKilled, boolean isWhite) {
        super(isKilled, isWhite);
    }

    public boolean canMove(int sX,int sY,int dX,int dY) {
        int X=abs(dX-sX);
        int Y=abs(dY-sY);
        if(X==0||Y==0||!(X==0&&Y==0))
            return true;
        else
            return false;
    }
}
