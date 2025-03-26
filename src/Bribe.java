import java.util.Random;

public class Bribe implements Command {

    private WorldMap world;
    private Player player;
    private static final String GOLD_POUCH = "Měšec zlaťáků";
    private static final int ESCAPE_LOCATION_ID = 4;
    private Random random = new Random();

    public Bribe(WorldMap world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String execute() {
        Inventory inventory = player.getInventory();
        Item goldPouch = null;
        for (Item item : inventory.getItems()) {
            if (item.getName().equalsIgnoreCase(GOLD_POUCH)) {
                goldPouch = item;
                break;
            }
        }

        if (goldPouch == null) {
            return "Nemáš čím podplatit strážce!";
        }

        Location currentLocation = player.getCurrentLocation();
        Charakter guard = null;
        for (Charakter character : currentLocation.getCharacters()) {
            if (character.getRole().equalsIgnoreCase("strážce")) {
                guard = character;
                break;
            }
        }

        if (guard == null) {
            return "Zde není žádný strážce, kterého bys mohl podplatit.";
        }

        inventory.getItems().remove(goldPouch);

        boolean success = random.nextBoolean();

        if (success) {
            Location newLocation = world.getWorld().get(ESCAPE_LOCATION_ID);
            world.setCurrentPosition(ESCAPE_LOCATION_ID);
            player.setCurrentLocation(newLocation);
            return "Podplácení bylo úspěšné! Stráž tě pustila dál do " + newLocation.getName();
        } else {
            return "Strážce úplatek odmítl a zavolal posily! Měl bys být opatrnější...";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}