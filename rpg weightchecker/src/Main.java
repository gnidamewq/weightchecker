import java.util.ArrayList;
import java.util.List;

class Item {
    String name;
    double weight;

    Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " (" + weight + " kg)";
    }
}

class Backpack {
    List<Item> items;

    Backpack() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item findHeaviestItem() {
        if (items.isEmpty()) {
            return null; // Рюкзак пуст
        }

        Item heaviestItem = items.get(0);

        for (Item item : items) {
            if (item.getWeight() > heaviestItem.getWeight()) {
                heaviestItem = item;
            }
        }

        return heaviestItem;
    }
}

public class Main {
    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        backpack.addItem(new Item("Sword", 3.5));
        backpack.addItem(new Item("Shield", 5.0));
        backpack.addItem(new Item("Potion", 0.5));
        backpack.addItem(new Item("Helmet", 1.5));

        Item heaviestItem = backpack.findHeaviestItem();

        if (heaviestItem != null) {
            System.out.println("The heaviest item in the backpack is: " + heaviestItem);
        } else {
            System.out.println("The backpack is empty.");
        }
    }
}