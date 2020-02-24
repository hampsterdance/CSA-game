public class GamePlayer{
  
  private String playerName;
  
  private int position;
  
  public GamePlayer(String name){
    
    position = 0;
    playerName = name;
    
  }
  
  public int move(){
    
    int movement = (int)(Math.random()*6 + 1);
    position += movement;
    return movement;
    
  }
  
  public void changePosition(int pos){
    position += pos;
  }
  
  public String toString(){
    return playerName + ": " + position;
  }
  
  public String getName(){
    return playerName;
  }
  
  public int getPosition(){
    return position;
  }
  
  public boolean ladder(){
    if(position%5 == 0){
      return true;
      //true will make it move up three spaces
    }
    return false;
  }
  
  public boolean slide(){
    if(position%3 == 0 && position != 15){
      return true;
      //true will make it move back two spaces
    }
    return false;
  }
  
}