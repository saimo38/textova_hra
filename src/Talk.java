import java.util.ArrayList;
import java.util.Scanner;

public class Talk implements Command {

    private Scanner sc = new Scanner(System.in);
    private Player player;

    public Talk(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        Location currentLocation = player.getCurrentLocation();
        ArrayList<Charakter> characters = currentLocation.getCharacters();

        if (characters.isEmpty()) {
            return "Zde není nikdo, s kým bys mohl mluvit.";
        }

        System.out.println("Dostupné postavy:");
        for (int i = 0; i < characters.size(); i++) {
            System.out.println((i + 1) + ": " + characters.get(i).getName());
        }
        System.out.print("Zadej číslo postavy, se kterou chceš mluvit: ");

        try {
            int input = sc.nextInt() - 1;

            if (input >= 0 && input < characters.size()) {Inventory inventory = player.getInventory();
                Item requiredItem = null;
                for (Item item : inventory.getItems()) {
                    if (item.getName().equalsIgnoreCase("Písmo svaté")) {
                        requiredItem = item;
                        break;
                    }
                }

                if (requiredItem != null) {
                    Item rewardItem = new Item("Ostrý kámen", "Kámen, který lze použít jako zbraň nebo k odstranění překážky");
                    inventory.getItems().remove(requiredItem);
                    player.getInventory().addItem(rewardItem);
                    return "Mnich ti dal na oplátku ostrý kámen";
                } else {
                    return "Nemáš Písmo svaté, a tak se s tebou mnich nechce bavit";
                }
            } else {
                return "Neplatný výběr.";
            }
        } catch (Exception e) {
            return "Neplatný vstup.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
