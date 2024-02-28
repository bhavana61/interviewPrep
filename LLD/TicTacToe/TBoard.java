package TicTacToe;

public class TBoard {
    String[][] board;
    int size;

    public TBoard(int n) {
        size=n;
        board=new String[size][size];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]="-";
            }
        }
    }

    public void displayBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Boolean playerWon(int row,int col,String playersymbol){
        // check if the player wins
        if ((checkRow(row, playersymbol)) ||
                (checkColumn(col, playersymbol)) ||
                (row == col && checkDiagonal(playersymbol)) ||
                (col == size - row - 1 && checkAntiDiagonal(playersymbol))) {
            return true;
        }
        // No one wins
        return false;
    }

    private boolean checkDiagonal(String playersymbol) {
        for (int row = 0; row < size; row++) {
            if (!board[row][row].equals(playersymbol)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(String playersymbol) {
        for (int row = 0; row < size; row++) {
            if (!board[row][size - row - 1].equals(playersymbol)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, String playersymbol) {
        for (int row = 0; row < size; row++) {
            if (!board[row][col].equals(playersymbol)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, String playersymbol) {
        for (int col = 0; col < size; col++) {
            if (!board[row][col].equals(playersymbol)) {
                return false;
            }
        }
        return true;
    }
}
