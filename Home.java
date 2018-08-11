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

    /** getter for peaches stored at Home location by player */
    public Map<Player, ArrayList<Peach>> getPeaches(){ return peaches; }

    /** When a player calls the getHelp method, this method instantiates a new helper, sends them to that player's
     * location, and gives the player 10 ripe peaches. The helper then returns to Home, where they remain.
     * @param p the player who calls the getHelp method
     * @param l that player's current location
     */
    public void callForHelp(Player p, Location l){
        Helper helper = new Helper(this.getWorld(),null, this.getWorld().getHome(), new ArrayList<Peach>(), 1000000, null);
        for (int i = 0; i < 10; i++) { // instantiate 10 ripe peaches
            helper.peaches.add(new Peach(10, false));
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


    public static void main(String[] args) {
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

        p.storeAtHome(2);

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
    }
}
