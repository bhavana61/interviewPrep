package Chess;

public class Move {
    int sX;
    int sY;
    int dX;
    int dY;
    Piece piece;

    public Move(int sX, int sY, int dX, int dY, Piece piece) {
        this.sX = sX;
        this.sY = sY;
        this.dX = dX;
        this.dY = dY;
        this.piece = piece;
    }
}
