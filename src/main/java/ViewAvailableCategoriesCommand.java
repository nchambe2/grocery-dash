import java.util.Collection;

public class ViewAvailableCategoriesCommand implements Command{
    private final GroceryCatalog groceryCatalog;
    private final Collection<String> availableCategories;

    public ViewAvailableCategoriesCommand(GroceryCatalog groceryCatalog, Collection<String> availableCategories) {

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
