import java.util.ArrayList;

public class Location {

    private String name;
    private int id;
    private ArrayList<Integer> locations;
    private boolean locked;
    private boolean unlockedWithoutTorch;
    private ArrayList<Item> items;
    private ArrayList<Charakter> characters;

    public Location() {
    }

    public Location(int id, String name, ArrayList<Integer> locations, boolean locked) {
        this.id = id;
        this.name = name;
        this.locations = locations;
        this.locked = locked;
        this.unlockedWithoutTorch = false;
        this.items = new ArrayList<>();
        this.characters = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addCharacter(Charakter character) {
        characters.add(character);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getLocations() {
        return locations;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isUnlockedWithoutTorch() {
        return unlockedWithoutTorch;
    }

    public void setUnlockedWithoutTorch(boolean unlockedWithoutTorch) {
        this.unlockedWithoutTorch = unlockedWithoutTorch;
    }

    public ArrayList<Charakter> getCharacters() {
        return characters;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", locations=" + locations +
                ", locked=" + locked +
                ", unlockedWithoutTorch=" + unlockedWithoutTorch +
                ", items=" + items +
                ", characters=" + characters +
                '}';
    }
}
