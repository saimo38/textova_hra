import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private WorldMap m = new WorldMap();
    private Inventory i = new Inventory(2);

    public void inicialization(){
        Player p = new Player("Eldric", i, m.getCurrentLocation(m.getStart()));
        map.put("goto", new GoTo(m, p));
        map.put("help", new Help());
        map.put("pickup", new PickUp(p));
        map.put("inventory", i);
        map.put("hint", new Hint());
        map.put("end", new End(this));
        map.put("explore", new Explore(p));
        map.put("putdown", new PutDown(p));
        map.put("talk", new Talk(p));
        map.put("bribe", new Bribe(m, p));
    }

    public void run (){
        System.out.print(">>");
        String command = sc.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        if(map.containsKey(command)){
            System.out.println(">> "+ map.get(command).execute());
            if (map.get(command).exit()){
                exit = true;
            }
        }else{
            System.out.println(">> Wrong command");
        }
    }

    public void start(){
        m.loadMap();
        inicialization();
        loadItems();
        loadCharacters();
        try {
            do {
                run();
            } while (!exit);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void loadItems(){
        for (Item item : Loader.loadItems("items.txt")) {
            Location location = m.getCurrentLocation(item.getLocationId());
            location.addItem(item);
        }
    }

    public void loadCharacters() {
        for (Charakter character : Loader.loadCharacters("characters.txt")) {
            Location location = m.getCurrentLocation(character.getLocationId());
            location.addCharacter(character);
        }
    }

    public HashMap<String, Command> getMap() {
        return map;
    }
}
