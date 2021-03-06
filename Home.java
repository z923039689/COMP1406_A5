package A5;

import java.util.*;

public class Home extends Location {

    // used to keep track of peaches players have stockpiled at the Home location
    protected Map<Player, ArrayList<Peach>> peaches;

    public Home(World w, Position p, String description, List<Player> people, List<Peach> peaches){
        super(w, p, description, people, peaches);
        this.position = new Position(0,0); // ensures there will never be more than 1 home created
        this.description = "A Home is the home location. There is only one home in each world. " +
                "This is where several of the players will begin the game. \n\n" +
                "It is a place for players to drop off (to stockpile) peaches. The home keeps track of how " +
                "many peaches each player brings back.\n\n" +
                "The home will also create a new Helper player to go help another player in distress (low health). " +
                "It will give the helper the \nlocation of the player in distress and some peaches to give to the " +
                "distressed player to eat.\n";
        this.peaches = new HashMap<Player, ArrayList<Peach>>();
    }

    /** getter for peaches stored at Home location for all players */
    public Map<Player, ArrayList<Peach>> getPeaches(){ return peaches; }

    /** getter for peaches stored at Home location for a specific player */
    public ArrayList<Peach> getPeaches(Player p){
        if (!peaches.containsKey(p)) {return new ArrayList<>();}
        return peaches.get(p);
    }

    /** When a player calls the getHelp method, this method instantiates a new helper, sends them to that player's
     * location, and gives the player 10 ripe peaches. The helper then returns to Home, where they remain.
     * @param p the player who calls the getHelp method
     * @param l that player's current location
     */
    public void callForHelp(Player p, Location l){
        Helper helper = new Helper(this.getWorld(),null, this.getWorld().getHome(), new ArrayList<Peach>(), 1000000, null);
        for (int i = 0; i < 10; i++) { // instantiate 10 good peaches with varying levels of ripeness
            helper.peaches.add(new Peach(new Random().nextInt(10) + 1, false));
        }
        helper.setLocation(l);
        helper.interact(p); // give the 10 ripe peaches to the player in distress
        helper.setLocation(this);
    }

    // Home location does not store any peaches outside of player inventory
    @Override
    public Peach getPeach(){return null;}

    @Override
    public void addPeach(Peach p) {}


}
