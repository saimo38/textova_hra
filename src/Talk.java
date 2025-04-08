import java.util.ArrayList;
import java.util.Scanner;

public class Talk implements Command {

    private Scanner sc = new Scanner(System.in);
    private Player player;

    public Talk(Player player) {
        this.player = player;
    }

    /**
     * Příkaz talk umožňuje uživateli mluvit s postavami.
     *
     * @return vrátí informaci, jestli příkaz bylo možné uskutečnit
     */
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

            if (input >= 0 && input < characters.size()) {
                Charakter selectedChar = characters.get(input);
                String charName = selectedChar.getName().toLowerCase();

                switch (charName) {
                    case "bratr marcus":
                        return interactWithMonk();
                    case "strážce":
                        return interactWithGuard();
                    default:
                        return selectedChar.getName() + " s tebou zatím nechce mluvit.";
                }
            } else {
                return "Neplatný výběr.";
            }
        } catch (Exception e) {
            return "Neplatný vstup.";
        }
    }

    /**
     * Umožňuje interakci s mnichem.
     * @return vrátí výsledek rozhovoru s mnichem.
     */
    private String interactWithMonk() {
        Inventory inventory = player.getInventory();
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
            inventory.addItem(rewardItem);
            return "Mnich ti poděkoval za Písmo svaté a dal ti ostrý kámen.";
        } else {
            return "Nemáš Písmo svaté, a tak se s tebou mnich nechce bavit.";
        }
    }

    /**
     * Umožňuje interakci se strážcem.
     * @return vrací výsledek rozhovoru se strážcem.
     */
    private String interactWithGuard() {
        return "Strážce tě varuje, abys nedělal žádné hlouposti.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
