package inventory;

public class Item {
    public String name;
    /**
     * Sell value.
     */
    int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + " $" + value;
    }
}
