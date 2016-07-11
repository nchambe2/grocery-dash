import java.io.PrintStream;

public class MenuValidator {
    private final ItemCatalog itemCatalog;
    private final PrintStream printStream;

    public MenuValidator(ItemCatalog itemCatalog, PrintStream printStream) {

        this.itemCatalog = itemCatalog;
        this.printStream = printStream;
    }

    public void validate(String userInput) {
        if (userInput.equals("Browse by Items")) {
            itemCatalog.listItems();
        } else if (userInput.equals("Browse by Category")) {
            itemCatalog.listCategories();
        } else {
            printStream.println("Invalid Selection");
        }
    }


    //or I print the categories
    //prompt the user to enter a category
    //then search through the available items
    //print items to the console that have that category
}
