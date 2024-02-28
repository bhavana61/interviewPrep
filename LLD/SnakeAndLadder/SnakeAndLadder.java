package SnakeAndLadder;

import java.util.List;
import java.util.Random;

public class SnakeAndLadder {
    List<Snake> snakeList;
    List<Ladder> ladderList;
    List<Player> playerMap;
    static Boolean gameOver=false;

    public SnakeAndLadder(List<Snake> snakeList, List<Ladder> ladderList, List<Player> playerMap) {
        this.snakeList = snakeList;
        this.ladderList = ladderList;
        this.playerMap = playerMap;
    }

    public void start(){
        do{
            for(Player p:playerMap){
                p.position=nextPosition(p);
                System.out.println(p.id+" position = "+p.position);
                if(gameOver){
                    System.out.println("player of id "+p.id+" has won the game");
                    break;
                }
            }
        }while(!gameOver);
    }

    public int roll(){
        Random random = new Random(); /* <-- this is a constructor */
        return random.nextInt(6) + 1;
    }

    public int nextPosition(Player player){
        int currentPosition=player.position;
        int nextPosition=currentPosition+roll();
        if(nextPosition==100){
            gameOver=true;
        }
        else if(nextPosition>100){
            nextPosition=currentPosition;
        }
        else{
            for(Snake s:snakeList){
                if(s.start==nextPosition){
                    nextPosition=s.end;
                    System.out.println(player.id+"snake start = "+s.start+" snake end = "+s.end);
                    break;
                }
            }
            for(Ladder l:ladderList){
                if(l.start==nextPosition){
                    nextPosition=l.end;
                    System.out.println(player.id+"ladder start = "+l.start+" ladder end = "+l.end);
                    break;
                }
            }
        }
        return nextPosition;
    }
}
