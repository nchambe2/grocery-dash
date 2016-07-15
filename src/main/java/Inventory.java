import java.io.PrintStream;
import java.util.Map;

public class Inventory {
    private final Map<String, String> availableItems;
    private final PrintStream printStream;
    private final Map<String, String> itemsToBePurchased;

    public Inventory(Map<String, String> availableItems, PrintStream printStream, Map<String, String> itemsToBePurchased) {
        this.availableItems = availableItems;
        this.printStream = printStream;
        this.itemsToBePurchased = itemsToBePurchased;
    }

    public void list(Map<String, String> availableItems) {
        String itemInformation = "";

        for(Map.Entry<String, String> item : availableItems.entrySet()) {
            itemInformation += item.getKey() + ". " + item.getValue() + "\n";
        }

        printStream.println(itemInformation);
    }

    public void listItemsIn(String selectedCategory) {
        String itemInformation = "";

        for(Map.Entry<String, String> item : availableItems.entrySet()) {
            //doing more then iterating
            if(item.getValue().contains(selectedCategory)) {
                itemInformation += item.getKey() + ". " + item.getValue() + "\n";
            }
        }

        printStream.println(itemInformation);
    }
    
    public boolean isItemInStock(String itemKey) {
        return availableItems.containsKey(itemKey);
    }

    public void addItemToItemsToBePurchased(String itemKey) {
        String itemInformation = availableItems.remove(itemKey);
        itemsToBePurchased.put(itemKey, itemInformation);
        printStream.println("Item has been added to basket.");
    }

    public void add(String itemKey, String itemToPlaceInInventory) {
        availableItems.put(itemKey, itemToPlaceInInventory);
        printStream.println("Item has been placed back on shelf");
    }
}
