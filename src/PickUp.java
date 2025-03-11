public class PickUp implements Command{

    private Location location;
    private Inventory inventory;

    public PickUp(Location location, Inventory inventory) {
        this.location = location;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
