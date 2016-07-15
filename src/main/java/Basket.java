import java.io.PrintStream;
import java.util.Map;

public class Basket {
    private final PrintStream printStream;
    private final Map<String, String> itemsToBePurchased;

    public Basket(PrintStream printStream, Map<String, String> itemsToBePurchased) {

        this.printStream = printStream;
        this.itemsToBePurchased = itemsToBePurchased;
    }

    public void display() {
        String itemToBePurchased = "";

        for(Map.Entry<String, String> item : itemsToBePurchased.entrySet()) {
            itemToBePurchased += item.getKey() + ". " + item.getValue() + "\n";
        }

       printStream.println(itemToBePurchased);
    }

    public void add(String itemKey, String itemToPlaceInBasket) {
        itemsToBePurchased.put(itemKey, itemToPlaceInBasket);
        printStream.println("Item has been added to your basket.");
    }

    public void remove(String itemKey) {
        itemsToBePurchased.remove(itemKey);
        printStream.println("Item has successfully been removed");
    }

    public Boolean isItemInBasket(String itemKey) {
        for(Map.Entry<String, String> item : itemsToBePurchased.entrySet()) {
            return item.getKey().equals(itemKey);
        }

        return false;
    }

    //getting valid input
    //should return only a valid item
    //valid item or not
    //doesn't have to have basket
}
