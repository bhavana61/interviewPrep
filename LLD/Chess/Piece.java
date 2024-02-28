package Chess;

public abstract  class Piece {
    public boolean isKilled;
    public boolean isWhite;
    public boolean isKing=false;

    public Piece(boolean isKilled,boolean isWhite){
        this.isKilled=isKilled;
        this.isWhite=isWhite;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public abstract boolean canMove(int sX,int sY,int dX,int dy);


}
