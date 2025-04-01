import java.util.ArrayList;

public class Explore implements Command {

    private Player player;

    public Explore(Player player) {
        this.player = player;
    }

    /**
     * Příkaz explore hráči vypíše všechny charaktery a itemy, které se v místnosti nachází.
     * @return vrátí informace o itemech a charakterech v místnosti
     */
    @Override
    public String execute() {
        Location currentLocation = player.getCurrentLocation();
        if (currentLocation == null) {
            return "Chyba: Nenacházíš se v žádné lokaci.";
        }

        StringBuilder output = new StringBuilder("Nacházíš se v: " + currentLocation.getName() + "\n");

        ArrayList<Item> items = currentLocation.getItems();
        if (items == null || items.isEmpty()) {
            output.append("Zde nejsou žádné předměty.\n");
        } else {
            output.append("Dostupné předměty:\n");
            for (Item item : items) {
                output.append("- ").append(item.getName()).append(": ").append(item.getDescription()).append("\n");
            }
        }

        ArrayList<Charakter> characters = currentLocation.getCharacters();
        if (characters == null || characters.isEmpty()) {
            output.append("Zde nejsou žádné postavy.\n");
        } else {
            output.append("Dostupné postavy:\n");
            for (Charakter character : characters) {
                output.append("- ").append(character.getName()).append(" (" + character.getRole() + ")\n");
            }
        }

        return output.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
