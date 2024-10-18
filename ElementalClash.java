/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted on the course website, and (3) any study notes handwritten by myself.
I have not used, accessed, or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME, AND STUDENT ID
SIGNATURE: <Berke Korlu, Student id:82883>
********************************************************************************/
package game;
import java.util.Scanner;
import java.util.Random;
public class ElementalClash {

	private Player player1;
   private  Player player2; 
    private int numRounds; 
   private static final Random RAND = new Random(2024);
    int scoreDif;
    int currentDif;
    
    
    public ElementalClash(String name1, String name2, int numRounds, int scoreDif) {
    	this.player1 = new Player (name1);
        this.player2 = new Player (name2);
        this.numRounds= numRounds;
    	this.scoreDif =scoreDif;
    }
    
    public ElementalClash(String name1, String name2, int numRounds){
    
        this.player1 = new Player (name1);
        this.player2 = new Player (name2);
        this.numRounds= numRounds;
    }
    private String getRandomChoice(){
    	int rastgele = RAND.nextInt(5);
    	if (rastgele ==0){
    		return "Fire";}
    	if (rastgele ==1){
    		return "Water";}
    	if (rastgele ==2){
    		return "Earth";}
    	if (rastgele ==3){
    		return "Air";}
    	else {
    		return "Lightning";}
 
    	}
    
    private String determineWinner(String choice1, String choice2) {
       
        if (choice1==("Fire")) {
            if (choice2==("Fire")) {
            	
            	return "tie";
                
            } else if (choice2==("Air")) {
                player1.wonRound();
                return player1.getName();
            } else if (choice2==("Lightning")) {
                player1.wonRound();
                return player1.getName();
            } else {
                player2.wonRound();
                return player2.getName();
            }
        }

        if (choice1==("Water")) {
            if (choice2==("Water")) {
            	
                return "tie";
            }else if (choice2==("Fire")) {
                player1.wonRound();
                return player1.getName();
            }else {
                player2.wonRound();
                return player2.getName();
            }
        }

        if (choice1==("Earth")) {
            if (choice2==("Earth")) {
            	
                return "tie";
            } else if (choice2==("Fire")) {
                player1.wonRound();
                return player1.getName();
            } else if (choice2==("Water")) {
                player1.wonRound();
                return player1.getName();
            } else {
                player2.wonRound();
                return player2.getName();
            }
        }

        if (choice1==("Air")) {
            if (choice2==("Air")) {
            	
                return "tie";
            } else if (choice2==("Water")) {
                player1.wonRound();
                return player1.getName();
            } else if (choice2==("Earth")) {
                player1.wonRound();
                return player1.getName();
            }else {
                player2.wonRound();
                return player2.getName();
            }
        }

        if (choice1==("Lightning")) {
           if (choice2==("Lightning")) {
        	   
                return "tie";
            } else if (choice2==("Fire")) {
                player2.wonRound();
                return player2.getName();
            } else {
                player1.wonRound();
                return player1.getName();
            }
        }

        return "tie";
    }


        
    	
    

        
    	
    
public void printWinner(){
	System.out.println(player1.getName()+" won: "+ player1.getRoundsWon()+" games\n" + player2.getName() +" won: "+ player2.getRoundsWon()+" games");
	if (player1.getRoundsWon()> player2.getRoundsWon()){
		System.out.println(player1.getName()+ " is the final winner!");
	}
	if (player2.getRoundsWon()> player1.getRoundsWon()){
		System.out.println(player2.getName()+ " is the final winner!");
	}
	if (player1.getRoundsWon()== player2.getRoundsWon()){
		System.out.println("There is no winner the game is tied");
   }if (( numRounds - player1.getRoundsWon()+ player2.getRoundsWon())==0){
		System.out.println("There is no tie");
   }else if (( numRounds - player1.getRoundsWon()+ player2.getRoundsWon())==1){
		System.out.println("There is 1 tie");		
   }else  {
		System.out.println("There are "+( numRounds - player1.getRoundsWon()- player2.getRoundsWon()) +" ties");	
	}
}
public void runGame(){
	

	for (int x = 0 ; x < numRounds ; x++){
		String playerChoice1= getRandomChoice();
		String playerChoice2= getRandomChoice();
		System.out.println("\nRound " + x);
	    System.out.println( player1.getName() + " chose " + playerChoice1 );
	    System.out.println( player2.getName() + " chose " + playerChoice2 );
	    
	    String winner = determineWinner(playerChoice1,playerChoice2);
	    
	    if (winner == player1.getName()){
	    	System.out.println( "Result: "+ player1.getName() + " wins");
	    }else if (winner == player2.getName()){
	    	System.out.println( "Result: "+ player2.getName() + " wins");
	    }else {
	    	System.out.println("Result: It's a tie!");
	    }
	}
	System.out.println("\nGame is over");

 
}public void runInLabGame(){
	for (int y = 0 ; y < numRounds ; y++){
		if (player1.getRoundsWon()>player2.getRoundsWon()){
	    	currentDif= player1.getRoundsWon()-player2.getRoundsWon();
	    if (player1.getRoundsWon()<player2.getRoundsWon()){
		    currentDif= player2.getRoundsWon()-player1.getRoundsWon();
		if (player1.getRoundsWon()==player2.getRoundsWon()){
		    currentDif= 0;
		    }
		String playerChoice1= getRandomChoice();
		String playerChoice2= getRandomChoice();
		System.out.println("\nRound " + y);
	    System.out.println( player1.getName() + " chose " + playerChoice1 );
	    System.out.println( player2.getName() + " chose " + playerChoice2 );
	    
	    System.out.println(player1.getName()+" won: "+ player1.getRoundsWon()+" games\n" + player2.getName() +" won: "+ player2.getRoundsWon()+" games");
	    
	    System.out.println("Score difference is:"+ currentDif);
	    
	    String winner = determineWinner(playerChoice1,playerChoice2);
	    
	    if (winner == player1.getName()){
	    	System.out.println( "Result: "+ player1.getName() + " wins");
	    }else if (winner == player2.getName()){
	    	System.out.println( "Result: "+ player2.getName() + " wins");
	    }else {
	    	System.out.println("Result: It's a tie!");
	    }
	}
	System.out.println("\nGame is over");
}


}
}
}