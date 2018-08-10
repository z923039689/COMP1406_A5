package A5;

import java.util.*;

public class Home extends Location {

    protected String desc = "A Home is the home location. There is only one home in each world. " +
            "This is where several of the players will begin the game. \n\n" +
            "It is a place for players to drop off (to stockpile) peaches. The home keeps track of how " +
            "many peaches each player brings back.\n\n" +
            "The home will also create a new Helper player to go help another player in distress (low health). " +
            "It will give the helper the \nlocation of the player in distress and some peaches to give to the " +
            "distressed player to eat.";

    public Map<Player, ArrayList<Peach> > peaches;

    public Home(Position p, String description, List<Player> people, List<Peach> peaches){
        super(p, description, people, peaches);
        this.position = new Position(0,0);
        this.description = desc;
        this.peopleAtLocation = new ArrayList<>();
        this.peachesAtLocation = new ArrayList<>();
        this.peaches = new HashMap<Player, ArrayList<Peach> >();
    }

    public static void main(String[] args) {
        World w = new World();
        Player p = new Player(w, "cat", w.home, new ArrayList<Peach>(), 50, RGB.YELLOW);
        Player q = new Player(w, "dog", w.home, new ArrayList<Peach>(), 100, RGB.BLUE);
        w.addPlayer(p).addPlayer(q);
        System.out.println(w.getHome().peachesAtLocation);
        System.out.println(w.getHome().peopleAtLocation);
        System.out.println(w.getHome().position);
        System.out.println(w.getHome().description);
        p.peaches.add(new Peach(10, false));
        p.peaches.add(new Peach(9, false));
        p.peaches.add(new Peach(1, true));
        System.out.println(Arrays.toString(p.peaches.toArray()));

        p.dropOffAtHome(2);

        System.out.println(w.home.peaches.toString());
        System.out.println(p.peaches.toString());
    }
}
