import java.io.PrintStream;
import java.util.Map;

public class Basket {
    private final PrintStream printStream;
    private final Map<String, String> itemsToBePurchased;
    private final Inventory inventory;

    public Basket(PrintStream printStream, Map<String, String> itemsToBePurchased, Inventory inventory) {

        this.printStream = printStream;
        this.itemsToBePurchased = itemsToBePurchased;
        this.inventory = inventory;
    }

    public void display() {
        String itemToBePurchased = "";

        for(Map.Entry<String, String> item : itemsToBePurchased.entrySet()) {
            itemToBePurchased += item.getKey() + ". " + item.getValue() + "\n";
        }

       printStream.println(itemToBePurchased);
    }

    public Boolean isItemInBasket(String itemKey) {
        return itemsToBePurchased.containsKey(itemKey);
    }

    public void returnToInventory(String itemKey) {
       String itemInformation = itemsToBePurchased.remove(itemKey);
       inventory.add(itemKey, itemInformation);
    }

    //getting valid input
    //should return only a valid item
    //valid item or not
    //doesn't have to have basket
}
