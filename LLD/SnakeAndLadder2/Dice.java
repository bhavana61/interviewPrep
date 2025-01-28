package SnakeAndLadder2;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int numberOfDice;

    public Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }
    
    public int roll(){
        return ThreadLocalRandom.current().nextInt(1,numberOfDice*6);
    }
}
