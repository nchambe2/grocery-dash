import java.util.Map;

public class ViewAvailableCategoriesCommand implements Command{
    private final GroceryCatalog groceryCatalog;
    private final Map<String, String> availableCategories;

    public ViewAvailableCategoriesCommand(GroceryCatalog groceryCatalog, Map<String, String> availableCategories) {

        this.groceryCatalog = groceryCatalog;
        this.availableCategories = availableCategories;
    }

    //builds a string
    //then print it
    @Override
    public void run() {
        groceryCatalog.list(availableCategories);
    }
}
