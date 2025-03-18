import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private WorldMap m = new WorldMap();
    private Inventory i = new Inventory(2);
    private End e = new End();
    private Player p = new Player("Eric", i, m.getCurrentLocation(m.getStart()));

    public void inicialization(){
        map.put("goto", new GoTo(m));
        map.put("help", new Help());
        //map.put("pickup", new PickUp());
        map.put("inventory", i);
        map.put("hint", new Hint());
        map.put("end", new End());
    }

    public void run (){
        System.out.print(">>");
        String command = sc.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        if(map.containsKey(command)){
            System.out.println(">> "+ map.get(command).execute());
        }else{
            System.out.println(">> Wrong command");
        }
    }

    public void start(){
        inicialization();
        m.loadMap();
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
