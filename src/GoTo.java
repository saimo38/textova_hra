import java.util.Scanner;

public class GoTo implements Command {

    private Scanner sc = new Scanner(System.in);
    private Location currentLocation = new Location();
    private Location newLocation = new Location();
    private WorldMap world;
    private Player player;

    public GoTo(WorldMap world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public String execute() {
        int currentID = world.getCurrentPosition();
        Location currentLocation = world.getCurrentLocation(currentID);

        System.out.println("Současná lokace: " + currentLocation.getName());
        System.out.println("Dostupná ID: " + currentLocation.getLocations());
        System.out.println("Zadej ID nové lokace");
        System.out.print(">> ");

        try {
            int targetID = sc.nextInt();

            if (!world.getWorld().containsKey(targetID)) {
                return "Tahle lokace neexistuje.";
            }

            Location newLocation = world.getWorld().get(targetID);

            if (newLocation.isLocked()) {
                Inventory inventory = player.getInventory();
                boolean hasKey = false;

                for (Item item : inventory.getItems()) {
                    if (item.getName().equalsIgnoreCase("Ostrý kámen")) {
                        hasKey = true;
                        inventory.getItems().remove(item);
                        break;
                    }
                }

                if (hasKey) {
                    newLocation.setLocked(false);
                    newLocation.setUnlockedWithoutTorch(true);
                    System.out.println("Lokace byla odemčena! Ale je tam tma, potřebuješ pochodeň.");
                } else {
                    return "Tahle lokace je zamčená.";
                }
            }

            // Pokud lokace byla odemčena, zkontrolujeme pochodeň
            if (newLocation.isUnlockedWithoutTorch()) {
                Inventory inventory = player.getInventory();
                boolean hasTorch = false;

                for (Item item : inventory.getItems()) {
                    if (item.getName().equalsIgnoreCase("Pochodeň")) {
                        hasTorch = true;
                        break;
                    }
                }

                if (!hasTorch) {
                    return "Je tam úplná tma! Potřebuješ pochodeň, aby ses mohl dostat dál.";
                } else {
                    newLocation.setUnlockedWithoutTorch(false);
                }
            }

            // Přesun do nové lokace
            if (currentLocation.getLocations().contains(targetID)) {
                world.setCurrentPosition(targetID);
                player.setCurrentLocation(newLocation);
                if (targetID == 8) {
                    System.out.println("Gratuluji! Dokončil jsi hru.");
                    System.exit(0);
                }
                return "Šel jsi do " + newLocation.getName();
            } else {
                return "Tam jít nemůžeš.";
            }

        } catch (Exception e) {
            System.out.println("Zadal jsi špatný input.");
        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
