import java.util.ArrayList;

public class Inventory implements Command {

    private ArrayList<Item> items;
    private int capacity;

    public Inventory(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public void addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
        } else {
            System.out.println("Inventář je plný!");
        }
    }

    @Override
    public String execute() {
        if (items.isEmpty()) {
            return "Inventář je prázdný.";
        }
        StringBuilder sb = new StringBuilder("Tvůj inventář:\n");
        for (Item item : items) {
            sb.append("- ").append(item.getName()).append(": ").append(item.getDescription()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
