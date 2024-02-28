package Chess;

import static java.lang.Math.abs;

public class King extends Piece{
    public King(boolean isKilled, boolean isWhite) {
        super(isKilled, isWhite);
    }

    public boolean canMove(int sX,int sY,int dX,int dY) {
        int X=abs(dX-sX);
        int Y=abs(dY-sY);
        if((X==1&&Y==0)||(X==0&&Y==1)||(X*Y==1))
            return true;
        else
            return false;
    }
}
