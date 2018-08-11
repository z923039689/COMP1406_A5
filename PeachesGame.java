package A5;

import java.util.ArrayList;
import java.util.Arrays;

public class PeachesGame{
  public static void main(String[] args){
    World w = new World();
    Player p = new Player(w, "cat", w.home, new ArrayList<Peach>(), 50, RGB.YELLOW);
    Player q = new Player(w, "dog", w.getLocations().get(1), new ArrayList<Peach>(), 9, RGB.BLUE);
    w.addPlayer(p).addPlayer(q);

    System.out.println(w.getHome().description);
    System.out.println(w.getHome().position);
    System.out.println(w.getHome().peachesAtLocation);
    System.out.println(w.getHome().peopleAtLocation);

    p.peaches.add(new Peach(10, false));
    p.peaches.add(new Peach(9, false));
    p.peaches.add(new Peach(1, true));
    System.out.println(Arrays.toString(p.peaches.toArray()));
    p.retrieveFromHome(2);

    p.storeAtHome(2);

    p.retrieveFromHome(3);
    System.out.println(w.home.peaches.toString());
    System.out.println(p.peaches.toString());
    q.play();
    System.out.println(q.peaches.toString());
    System.out.println(w.home.getPlayers().get(1).peaches.toString());
    System.out.println(w.getHome().peopleAtLocation);
    System.out.println(q.getHealth());
    q.eatPeach();
    System.out.println(q.peaches.toString());
    System.out.println(q.getHealth());
    q.storeAtHome(1);
    q.setLocation(w.getHome());
    q.storeAtHome(1);
    q.storeAtHome(1);
    q.storeAtHome(10);
    System.out.println(w.home.peaches.toString());
    System.out.println(w.home.getPlayers().get(1).equals(w.home.getPlayers().get(1)));
    System.out.println(p.peaches.toString());
    System.out.println(w.home.peaches.toString());
    System.out.println(w.home.getPeaches().toString());
      System.out.println(w.home.getPeaches(p));
    //p.retrieveFromHome(2);
    //System.out.println(p.peaches.toString());
    //System.out.println(w.home.peaches.toString());

    /*World w = new World();
    Player p = new Player(w, "cat", w.home, new ArrayList<Peach>(), 50, RGB.YELLOW);
    Player q = new Player(w, "dog", w.home, new ArrayList<Peach>(), 100, RGB.BLUE);
    w.addPlayer(p).addPlayer(q);
    
    System.out.println("Home : " + w.getHome());
    System.out.println("  Players at Home : " + w.getHome().getPlayers());
    System.out.println("Location of all players in world");
    for(Player pp: w.getPlayers()){
       System.out.println(pp.getLocation());
       System.out.println(pp.getLocation().getPlayers());
    }
    
    System.out.println("Move some players in world");
    p.move(Directions.DOWN);
    q.move(Directions.RIGHT);
    System.out.println("Location of all players in world");
    
    for(Player pp: w.getPlayers()){
       System.out.println(pp.getLocation());
       System.out.println(pp.getLocation().getPlayers());
    }
    
    
    // what the game might look like...
    while( w.getHome().numberOfPeaches() <= 100 ){
      // iterate over all locations in the world
      for(Location location: w.getLocations()){
        // iterate over all players in the current location
        for(Player player: location.getPlayers() ){
          System.out.println(player.getName() + ", " + player.getLocation());
          player.play();
        }
      }
      
    }
    */
  }
}