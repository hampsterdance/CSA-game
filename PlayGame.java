import java.util.Scanner;
import java.util.ArrayList;

public class PlayGame{
  
  public static void main(String[] args){
    
    int playerUnit = 0;
    int turn = 0;
    ArrayList<GamePlayer> players = new ArrayList<GamePlayer>();
    boolean gameOver = false;
    
    Scanner scan= new Scanner(System.in);
    
    //figures out how many people are playing
    System.out.println("How many people are playing?");
    int numberOfPlayers = scan.nextInt();
    scan.nextLine();
    
    //creates the players and places them in ArrayList
    for(int i = 0; i < numberOfPlayers; i++){
      
      playerUnit++;
      System.out.println("What is the name of player " + playerUnit + "?");
      String n = scan.nextLine();
      
      players.add(new GamePlayer(n));
      
    }
    
    //checks to see if game is over
    while(!gameOver){
      
      turn++;
      System.out.println("\nTurn " + turn + ":\n");
      
      //cycles through players
      for(GamePlayer p: players){
        //makes sure one of the previous players of the turn hasn't won already
        if(!gameOver){
          System.out.println(p.getName() + " moves " + p.move() + " spaces.");
          
          //checks to see if the player has hit a slide or ladder
          if(p.ladder()){
            p.changePosition(2);
            System.out.println(p.getName() + " has found a ladder! They move up two spaces!");
          }
          else if(p.slide()){
            p.changePosition(-3);
            System.out.println(p.getName() + " has hit a slide! They move back three spaces.");
          }
        }
        
        System.out.println();
        
        //checks to see if someone has won
        if(p.getPosition() >= 20){
          System.out.println(p.getName() + " wins!");
          gameOver = true;
        }
      }
      if(!gameOver){
        System.out.println("Press enter to continue");
        String holder = scan.nextLine();
      }
    }
  }
}