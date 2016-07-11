import java.io.PrintStream;
import java.util.Collection;

public class ItemCatalog {
    private final PrintStream printStream;
    private final Collection<Item> availableGroceryItems;
    private final Collection<Category> availableCategories;

    public ItemCatalog(PrintStream printStream, Collection<Item> availableGroceryItems, Collection<Category> availableCategories) {
        this.printStream = printStream;
        this.availableGroceryItems = availableGroceryItems;
        this.availableCategories = availableCategories;
    }

    public void listItems() {
        for(Item item : availableGroceryItems) {
            printStream.println(item.details());
        }
    }

    public void listCategories() {
        for(Category category : availableCategories) {
            printStream.println(category.getTitle());
        }
    }

}
