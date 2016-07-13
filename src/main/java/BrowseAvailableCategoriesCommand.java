import java.io.PrintStream;

public class BrowseAvailableCategoriesCommand implements Command{
    private final ItemCatalog itemCatalog;
    private final PrintStream printStream;

    public BrowseAvailableCategoriesCommand(ItemCatalog itemCatalog, PrintStream printStream) {

        this.itemCatalog = itemCatalog;
        this.printStream = printStream;
    }

    @Override
    public void run() {
        for(Category category : itemCatalog.getAvailableCategories()) {
            printStream.println(category.getTitle());
        }
    }
}
