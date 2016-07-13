import java.io.PrintStream;

public class BrowseAvailableCategoriesCommand implements Command{
    private final GroceryCatalog groceryCatalog;
    private final PrintStream printStream;

    public BrowseAvailableCategoriesCommand(GroceryCatalog groceryCatalog, PrintStream printStream) {

        this.groceryCatalog = groceryCatalog;
        this.printStream = printStream;
    }

    @Override
    public void run() {
        String categoriesToPrint = "";

        for(String category : groceryCatalog.getAvailableCategories()) {
            categoriesToPrint += category + "\n";
        }

        printStream.println(categoriesToPrint);
        //builds a string
        //then print it
    }
}
