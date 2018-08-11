package A5;

import java.util.List;

public class Helper extends Player {

    /*A Helper is created and dispatched from the home location whenever a player (pit finder or peach
            hunter) asks for help. They bring a bunch of peaches to the player (giving them to the player when they interact
            with them). Once a helper helps someone they go back home (and do nothing for the rest of the game). A
            helper will not give any peaches to a bear.
    */

    public Helper(World w, String name, Location location, List<Peach> peaches, int health, RGB rgb){
        super(w, name, location, peaches, health, rgb);
        this.location = w.home;
    }

    public void interact(Player p){
        for (int i = 0; i < this.peaches.size(); i++) {
            p.peaches.add(this.getPeach());
        }
    }
}
