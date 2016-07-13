import java.io.PrintStream;

public class BrowseAvailableItemsCommand implements Command{
    private final ItemCatalog itemCatalog;
    private final PrintStream printStream;

    public BrowseAvailableItemsCommand(ItemCatalog itemCatalog, PrintStream printStream) {

        this.itemCatalog = itemCatalog;
        this.printStream = printStream;
    }

    @Override
    public void run() {
        for(Item item : itemCatalog.getAvailableGroceryItems()) {
            printStream.println(item.details());
        }
    }
}
