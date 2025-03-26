import java.util.ArrayList;
import java.util.Scanner;

public class PickUp implements Command{

    private Scanner sc = new Scanner(System.in);
    private Player player;
    private WorldMap worldMap;

    public PickUp(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        Location currentLocation = player.getCurrentLocation();
        Inventory inventory = player.getInventory();

        if (inventory.isFull()) {
            return "Inventář je plný!";
        }

        ArrayList<Item> items = currentLocation.getItems();
        if (items.isEmpty()) {
            return "Zde není žádný předmět k sebrání.";
        }

        System.out.println("Dostupné předměty:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ": " + items.get(i).getName());
        }
        System.out.print("Zadej číslo předmětu, který chceš sebrat: ");

        try {
            int input = sc.nextInt() - 1;
            if (input >= 0 && input < items.size()) {
                Item item = items.remove(input);
                inventory.addItem(item);
                return "Sebral jsi " + item.getName();
            } else {
                return "Neplatný výběr.";
            }
        } catch (Exception e) {
            sc.next();
            return "Neplatný vstup.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
