package A5;

import java.util.List;
import java.util.Map;

public class Home extends Location {

   /* 1) A Home is the home location. There is only one home in each world. This is where several of the players
    will begin the game.

    Is is a place for players to drop off (to stockpile) peaches. The home keeps track of how
    many peaches each player brings back.

    The home will also create a new Helper player to go help another player in distress (low health). It will give
    the helper the location of the player in distress and some peaches to give to the distressed player to eat.*/

    protected Map<Player, Integer> peaches;

    public Home(Position p, String description, List<Player> people, List<Peach> peaches){
        super(p, description, people, peaches);
    }

    public void drop_off(int peaches) {

    }
}
