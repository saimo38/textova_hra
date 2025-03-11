import java.util.ArrayList;

public class Location {

    private String name;
    private int id;
    private ArrayList<Integer> locations;
    private boolean locked;

    public Location() {
    }

    public Location(int id, String name, ArrayList<Integer> locations, boolean locked) {
        this.id = id;
        this.name = name;
        this.locations = locations;
        this.locked = locked;
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

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", locations=" + locations +
                ", locked=" + locked +
                '}';
    }
}
