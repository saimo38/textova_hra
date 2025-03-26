import java.util.Scanner;

public class Use implements Command {

    private Player player;
    private Scanner sc = new Scanner(System.in);

    public Use(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        Inventory inventory = player.getInventory();
        Location currentLocation = player.getCurrentLocation();

        if (inventory.isEmpty()) {
            return "Tvůj inventář je prázdný!";
        }

        System.out.println("Jaký předmět chceš použít?");
        System.out.print(">> ");
        String itemName = sc.nextLine().trim();

        Item selectedItem = null;
        for (Item item : inventory.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                selectedItem = item;
                break;
            }
        }

        if (selectedItem == null) {
            return "Tento předmět nemáš v inventáři!";
        }

        if (selectedItem.getLocationId() != currentLocation.getId()) {
            return "Tento předmět zde nemůžeš použít!";
        }

        inventory.getItems().remove(selectedItem);

        return "Použil jsi předmět: " + selectedItem.getName() + "!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
