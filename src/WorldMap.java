import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WorldMap {

    private HashMap<Integer, Location> world = new HashMap<>();
    private int start = 3;
    private int currentPosition = start;

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                int id = Integer.parseInt(lines[0]);
                String name = lines[1];
                ArrayList<Integer> available = new ArrayList<>();
                boolean locked = false;
                for (int i = 2; i < lines.length; i++) {
                    if(lines[i].equals("locked")) {
                        locked = true;
                    } else {
                        available.add(Integer.parseInt(lines[i]));
                    }
                }
                Location l = new Location(id,name,available,locked);
                world.put(id, l);
            }
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Location getCurrentLocation(int id) {
        return world.get(id);
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setWorld(HashMap<Integer, Location> world) {
        this.world = world;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getStart() {
        return start;
    }
}
