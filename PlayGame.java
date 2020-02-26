/* Instructions
 * 
 * Your will lead your characters through a board of 20 squares using a six-sided die.
 * Watch out for the snakes that roam the board -- they will push you back 2 spaces if you land on them!
 * Try to reach ladders -- they will help you move forward 3 spaces!
 * At the end of each round you can press space to see the currrent standings.
 * 
 * Try to get to the crown first. Good luck!
 * 
 * @version Feb 26, 2020
 * @authors A. Irwin, G. Cunningham
 */

import java.util.Scanner;
import java.util.ArrayList;

public class PlayGame{
  
  public static void main(String[] args){
    
    int playerUnit = 0; 
    int turn = 0; 
    ArrayList<GamePlayer> players = new ArrayList<GamePlayer>();
    boolean gameOver = false;
    
    Scanner scan= new Scanner(System.in);
    
    //Figures out how many people are playing
    System.out.println("\nWelcome to Snakes and Ladders!\nYou are trying to get to the crown first using a six-sided die. \nAim for ladders and avoid snakes! \nIf you want to see the standings between rounds, press the space bar and then enter.\nGood luck!\n\nHow many people are playing?");
    int numberOfPlayers = scan.nextInt();
    scan.nextLine();
    
    //Creates the players and places them in ArrayList
    for(int i = 0; i < numberOfPlayers; i++){
      
      playerUnit++;
      System.out.println("What is the name of player " + playerUnit + "?");
      String n = scan.nextLine();
      
      players.add(new GamePlayer(n));
      
    }
    
    //Checks to see if game is over
    while(!gameOver){
      
      turn++;
      System.out.println("\nTurn " + turn + ":\n");
      
      //Cycles through players
      for(GamePlayer p: players){
        //Makes sure one of the previous players of the turn hasn't won already
        if(!gameOver){
          System.out.println(p.getName() + " moves " + p.move() + " spaces.");
          
          //Checks to see if the player has hit a slide or ladder
          if(p.ladder()){
            p.changePosition(3);
            System.out.println(p.getName() + " has found a ladder! They move up three spaces!");
          }
          else if(p.snake()){
            p.changePosition(-2);
            System.out.println(p.getName() + " has hit a snake! They move back two spaces.");
          }
        }
        
        System.out.println();
        
        //Checks to see if someone has won
        if(p.getPosition() >= 20){
          System.out.println(p.getName() + " wins!");
          gameOver = true;
        }
      }
      
      //Adds a transition so that the game moves slower
      if(!gameOver){
        System.out.println("Continue?");
        String standings = scan.nextLine();
        
        if(standings.equals(" ")){
          for(GamePlayer p: players){
            System.out.println(p);
          }
          System.out.println("Continue?");
          standings = scan.nextLine();
        }
      }
    }
    
  }
}

