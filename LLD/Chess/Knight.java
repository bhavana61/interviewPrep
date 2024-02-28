package Chess;

import static java.lang.Math.abs;

public class Knight extends Piece{
    public Knight(boolean isKilled, boolean isWhite) {
        super(isKilled, isWhite);
    }

    @Override
    public boolean canMove(int sX,int sY,int dX,int dY) {
        int X=abs(dX-sX);
        int Y=abs(dY-sY);
        if(X*Y==2)
            return true;
        else
            return false;
    }
}
