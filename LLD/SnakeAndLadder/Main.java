package SnakeAndLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Snake> snakeList;
        List<Ladder> ladderList;
        List<Player> players;

        Player p1=new Player(1);
        Player p2=new Player(2);
        Player p3=new Player(3);
        players=new ArrayList<Player>(Arrays.asList(p1,p2,p3));

        Snake s1=new Snake(96,54);
        Snake s2=new Snake(72,67);
        Snake s3=new Snake(12,2);
        snakeList=new ArrayList<Snake>(Arrays.asList(s1,s2,s3));

        Ladder l1=new Ladder(45,92);
        Ladder l2=new Ladder(8,22);
        Ladder l3=new Ladder(37,68);
        ladderList=new ArrayList<Ladder>(Arrays.asList(l1,l2,l3));

        SnakeAndLadder snakeAndLadder=new SnakeAndLadder(snakeList,ladderList,players);
        snakeAndLadder.start();
    }
}
