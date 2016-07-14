import java.util.Map;

public class ViewAvailableItemsCommand implements Command{

    private final Map<String, String> availableGroceryItems;
    private final GroceryCatalog groceryCatalog;

    public ViewAvailableItemsCommand(Map<String, String> availableGroceryItems, GroceryCatalog groceryCatalog) {

        this.availableGroceryItems = availableGroceryItems;
        this.groceryCatalog = groceryCatalog;
    }

    //just have the catalog list them
    //just move behavior into class
    @Override
    public void run() {
        groceryCatalog.list(availableGroceryItems);
    }
}
