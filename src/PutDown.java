public class PutDown implements Command{

    private Item item;
    private Inventory inventory;

    public PutDown(Item item, Inventory inventory) {
        this.item = item;
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
