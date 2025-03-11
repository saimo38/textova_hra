import java.util.Scanner;

public class GoTo implements Command{

    private Scanner sc = new Scanner(System.in);
    private Location currentLocation = new Location();
    private Location newLocation = new Location();
    private WorldMap world = new WorldMap();

    @Override
    public String execute() {
        int currentID = world.getCurrentPosition();
        currentLocation = world.getCurrentLocation(currentID);
        System.out.println("Current " + currentLocation);
        System.out.println("Current ID: " + currentID);
        System.out.println("Available IDs" + currentLocation.getLocations());
        System.out.println("Enter ID of the new location");
        System.out.println(">>");
        try {
            int input = sc.nextInt();
            int targetID = input;

            if (!world.getWorld().containsKey(targetID)) {
                return "This location does not exist";
            }

            newLocation = world.getWorld().get(targetID);

            if (newLocation.isLocked()) {
                return "This location is locked";
            }

            if (currentLocation.getLocations().contains(targetID)) {
                world.setCurrentPosition(targetID);
                return "You went to " + newLocation.getName();
            } else {
                return "You can't go there";
            }
        } catch (Exception e) {
            System.out.println("you entered an invalid input");
        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }

    public GoTo(WorldMap world) {
        this.world = world;
    }
}
