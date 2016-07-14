import java.util.Collection;

public class ViewAvailableItemsCommand implements Command{

    private final Collection<String> availableGroceryItems;
    private final GroceryCatalog groceryCatalog;

    public ViewAvailableItemsCommand(Collection<String> availableGroceryItems, GroceryCatalog groceryCatalog) {

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
