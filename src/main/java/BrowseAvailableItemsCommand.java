import java.io.PrintStream;

public class BrowseAvailableItemsCommand implements Command{
    private final GroceryCatalog groceryCatalog;
    private final PrintStream printStream;

    public BrowseAvailableItemsCommand(GroceryCatalog groceryCatalog, PrintStream printStream) {

        this.groceryCatalog = groceryCatalog;
        this.printStream = printStream;
    }

    @Override
    public void run() {
        for(Item item : groceryCatalog.getAvailableGroceryItems()) {
            printStream.println(item.details());
        }

        //just have the catalog list them

        //just move behavior into class
    }
}
