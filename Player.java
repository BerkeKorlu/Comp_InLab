package game;

import java.util.Scanner;
import java.util.Random;

public class Player {
	private int roundsWon  ;
    private String playerName;

    
    
    public Player(String name){
        
        this.playerName = name;
        this.roundsWon = 0;
    }
    
    
    public void wonRound(){
        roundsWon++;
    }
    public int getRoundsWon(){
        return roundsWon;
    }
    public String getName(){
        return playerName;
    }
}
