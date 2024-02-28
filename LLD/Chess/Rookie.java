package Chess;

public class Rookie extends Piece{
    public Rookie(boolean isKilled, boolean isWhite) {
        super(isKilled, isWhite);
    }

    public boolean canMove(int sX,int sY,int dX,int dY) {
        int X=Math.abs(dX-sX);
        int Y=Math.abs(dY-sY);
        if(X==Y)
            return true;
        else
            return false;
    }
}
