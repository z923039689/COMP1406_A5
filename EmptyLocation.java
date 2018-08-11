package A5;

import java.util.ArrayList;

public class EmptyLocation extends Location{
  public EmptyLocation(World w, Position p, String description){
    super(w, p, description, new ArrayList<Player>(), new ArrayList<Peach>());
  }
  
  /** getter for a Peach */
  public Peach getPeach(){ return null; } 
  
  
  /** remove a player from a room */
  public void remove(Player p){
    peopleAtLocation.remove(p);
  }
}
  
    