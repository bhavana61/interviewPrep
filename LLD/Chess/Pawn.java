package Chess;

import static java.lang.Math.abs;

public class Pawn extends Piece{
    public Pawn(boolean isKilled, boolean isWhite) {
        super(isKilled, isWhite);
    }

    public boolean canMove(int sX,int sY,int dX,int dY) {
        int X=abs(dX-sX);
        int Y=abs(dY-sY);
        if(X==1||(X==Y&&X==1)) {
            return true;
        } else
            return false;
    }
}
