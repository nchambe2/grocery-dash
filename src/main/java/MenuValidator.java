import java.io.PrintStream;

public class MenuValidator {
    private final ItemCatalog itemCatalog;
    private final PrintStream printStream;

    public MenuValidator(ItemCatalog itemCatalog, PrintStream printStream) {

        this.itemCatalog = itemCatalog;
        this.printStream = printStream;
    }

    public void validate(String userInput) {
        if (userInput.equals("Browse Available Items")) {
            itemCatalog.listItems();
        } else if (userInput.equals("Browse Available Categories")) {
            itemCatalog.listCategories();
        } else if(userInput.equals("Browse Available Items In A Category")) {
            itemCatalog.listItemsInASpecificCategory();
        } else {
            printStream.println("Invalid Selection");
        }
    }

}
