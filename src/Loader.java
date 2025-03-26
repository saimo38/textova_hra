import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Loader {
    public static ArrayList<Item> loadItems(String path) {
        ArrayList<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    int locationId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String description = parts[2].trim();

                    Item item = new Item(name, description);
                    item.setLocationId(locationId);
                    items.add(item);
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba při načítání itemů: " + e.getMessage());
        }

        return items;
    }
    public static ArrayList<Charakter> loadCharacters(String path) {
        ArrayList<Charakter> characters = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    int locationId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String role = parts[2].trim();

                    Charakter character = new Charakter(name, role);
                    character.setLocationId(locationId);
                    characters.add(character);
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba při načítání itemů: " + e.getMessage());
        }

        return characters;
    }

}
