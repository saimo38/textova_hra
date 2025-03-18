public class PickUp implements Command{

    private Location location;
    private Inventory inventory;
    private Player player;

    public PickUp(Location location, Player player) {
        this.location = location;
        this.player = player;
    }

    @Override
    public String execute() {
        Location currentLocation = player.getCurrentLocation();
        if (inventory.isFull()) {
            return "Inventář je plný!";
        }

        for (Item item : currentLocation.getItems()) {
            if (item.getLocationId() == currentLocation.getId()) {
                inventory.addItem(item);
                currentLocation.removeItem(item);
                return "Sebral jsi " + item.getName();
            }
        }
        return "Zde není žádný předmět k sebrání.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
