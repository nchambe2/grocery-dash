import java.io.PrintStream;
import java.util.List;

public class ItemCatalog {
    private final PrintStream printStream;
    private final List<String> availableGroceryItems;

    public ItemCatalog(PrintStream printStream, List<String> availableGroceryItems) {
        this.printStream = printStream;
        this.availableGroceryItems = availableGroceryItems;
    }

    public void list() {
        displayItemHeaderTitle();

        for(String item : availableGroceryItems) {
            printStream.println(item);
        }
    }

    private void displayItemHeaderTitle() {
        printStream.println("Item Name:\n--------------------");
    }
}
