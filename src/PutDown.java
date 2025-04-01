import java.util.Scanner;

public class PutDown implements Command{

    private Scanner sc = new Scanner(System.in);
    private Player player;

    public PutDown(Player player) {
        this.player = player;
    }

    /**
     * Příkaz putdown hráči umožňuje položit item.
     * @return vrátí informaci, jestli příkaz bylo možné uskutečnit
     */
    @Override
    public String execute() {
        Inventory inventory = player.getInventory();
        Location currentLocation = player.getCurrentLocation();

        if (inventory.isEmpty()) {
            return "Tvůj inventář je prázdný.";
        }

        System.out.println("Tvůj inventář:");
        for (int i = 0; i < inventory.getItems().size(); i++) {
            System.out.println((i + 1) + ": " + inventory.getItems().get(i).getName());
        }
        System.out.print("Zadej číslo předmětu, který chceš položit: ");

        try {
            int input = sc.nextInt() - 1;
            Item item = inventory.removeItem(input);
            if (item != null) {
                currentLocation.addItem(item);
                return "Položil jsi " + item.getName();
            } else {
                return "Neplatný výběr.";
            }
        } catch (Exception e) {
            sc.nextLine();
            return "Neplatný vstup.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
