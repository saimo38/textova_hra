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

    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Přidá item do inventáře.
     * @param item
     */
    public void addItem(Item item) {
        if (items.size() < capacity) {
            items.add(item);
        } else {
            System.out.println("Inventář je plný!");
        }
    }

    /**
     * Odebere item z inventáře.
     * @param index
     * @return
     */
    public Item removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Příkaz inventory vypíše obsah inventáře.
     * @return vrátí obsah inventáře
     */
    @Override
    public String execute() {
        if (items.isEmpty()) {
            return "Inventář je prázdný.";
        }
        StringBuilder sb = new StringBuilder("Tvůj inventář:");
        for (Item item : items) {
            sb.append("\n- ").append(item.getName()).append(": ");
        }
        return sb.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
