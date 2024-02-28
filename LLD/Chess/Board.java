package Chess;

public class Board {
    Box[][] box = new Box[8][8];

    public void resetBoard(){
        box[0][0]=new Box(0,0,true,new Bishop(false,true));
        box[0][1]=new Box(0,1,true,new Knight(false,true));
        box[0][2]=new Box(0,2,true,new Bishop(false,true));
        box[0][3]=new Box(0,3,true,new Queen(false,true));
        Piece wKing=new King(false,true);
        wKing.isKing=true;
        box[0][4]=new Box(0,4,true,wKing);
        box[0][5]=new Box(0,5,true,new Rookie(false,true));
        box[0][6]=new Box(0,6,true,new Knight(false,true));
        box[0][7]=new Box(0,7,true,new Bishop(false,true));

        box[7][0]=new Box(7,0,true,new Bishop(false,false));
        box[7][1]=new Box(7,1,true,new Knight(false,false));
        box[7][2]=new Box(7,2,true,new Rookie(false,false));
        box[7][3]=new Box(7,3,true,new Queen(false,false));
        Piece bKing=new King(false,false);
        bKing.isKing=true;
        box[7][4]=new Box(7,4,true,bKing);
        box[7][5]=new Box(7,5,true,new Rookie(false,false));
        box[7][6]=new Box(7,6,true,new Knight(false,false));
        box[7][7]=new Box(7,7,true,new Bishop(false,false));

        for(int i=0;i<8;i++){
            box[1][i]=new Box(i,1,true,new Pawn(false,true));
            box[6][i]=new Box(i,6,true,new Pawn(false,false));
        }

        for(int i=2;i<=5;i++){
            for (int j=0;j<8;j++){
                box[i][j]=new Box(i,j);
            }
        }
    }

    public void displayBoard(){
        for(int i=7;i>=0;i--){
            for(int j=0;j<=7;j++){
                System.out.println(box[i][j]);
            }
        }
    }
}
