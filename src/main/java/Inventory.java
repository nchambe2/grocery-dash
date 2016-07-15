import java.io.PrintStream;
import java.util.Map;

public class Inventory {
    private final Map<String, Item> availableItems;
    private final PrintStream printStream;
    private final Map<String, Item> itemsToBePurchased;

    public Inventory(Map<String, Item> availableItems, PrintStream printStream, Map<String, Item> itemsToBePurchased) {
        this.availableItems = availableItems;
        this.printStream = printStream;
        this.itemsToBePurchased = itemsToBePurchased;
    }

    public void list() {
        String itemInformation = "";

        for(Map.Entry<String, Item> itemEntry : availableItems.entrySet()) {
            itemInformation += itemEntry.getKey() + ". " + itemEntry.getValue().details() + "\n";
        }

        printStream.println(itemInformation);
    }

    public void listItemsIn(String selectedCategory) {
        String itemInformation = "";

        for(Map.Entry<String, Item> itemEntry : availableItems.entrySet()) {
//            Item currentItem = itemEntry.getValue();
//            if(currentItem.is(selectedCategory)) {
//
//            }
            if(isItemCategoryEqualToSelectedCategory(selectedCategory, itemEntry)) {
                itemInformation += itemEntry.getKey() + ". " + itemEntry.getValue().details() + "\n";
            }
        }

        printStream.println(itemInformation);
    }

    //item has a method to check for isCatagory??
    private boolean isItemCategoryEqualToSelectedCategory(String selectedCategory, Map.Entry<String, Item> item) {
        return item.getValue().getCategory().equals(selectedCategory);
    }

    public boolean isItemInStock(String itemKey) {
        return availableItems.containsKey(itemKey);
    }

    public void addItemToItemsToBePurchased(String itemKey) {
        //dont remove the item
        //just decrease the quanity by one
        Item itemInformation = availableItems.remove(itemKey);
        itemInformation.subtractOne();
        itemsToBePurchased.put(itemKey, itemInformation);
        printStream.println("Item has been added to basket.");
    }

    public void add(String itemKey, Item itemToPlaceInInventory) {
        availableItems.put(itemKey, itemToPlaceInInventory);
        printStream.println("Item has been placed back on shelf");
    }
}
