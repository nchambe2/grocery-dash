import java.io.PrintStream;
import java.util.Collection;

public class ItemCatalog {
    private final PrintStream printStream;
    private final Collection<Item> availableGroceryItems;

    public ItemCatalog(PrintStream printStream, Collection<Item> availableGroceryItems) {
        this.printStream = printStream;
        this.availableGroceryItems = availableGroceryItems;
    }

    public void list() {
        displayItemHeaderTitle();

        for(Item item : availableGroceryItems) {
            printStream.println(item.details());
        }
    }

    private void displayItemHeaderTitle() {
        printStream.println("Name      | Description     | Category      | Price\n----------------------------------------------------");
    }
}
