import java.util.Map;

public class ViewAvailableItemsCommand implements Command{

    private final Map<String, String> availableGroceryItems;
    private final Inventory inventory;

    public ViewAvailableItemsCommand(Map<String, String> availableGroceryItems, Inventory inventory) {

        this.availableGroceryItems = availableGroceryItems;
        this.inventory = inventory;
    }

    //just have the catalog list them
    //just move behavior into class
    @Override
    public void run() {
        inventory.list(availableGroceryItems);
    }
}
