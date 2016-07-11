import java.io.PrintStream;

public class MenuValidator {
    private final ItemCatalog itemCatalog;
    private final PrintStream printStream;
    private final UserInput userInput;

    public MenuValidator(ItemCatalog itemCatalog, PrintStream printStream, UserInput userInput) {

        this.itemCatalog = itemCatalog;
        this.printStream = printStream;
        this.userInput = userInput;
    }

    public void validate() {
        String menuSelection = userInput.getInput();

        if(menuSelection.equals("Browse Available Items")) {
            itemCatalog.listItems();
        } else if (menuSelection.equals("Browse Available Categories")) {
            itemCatalog.listCategories();
        } else if(menuSelection.equals("Browse Available Items In A Category")) {
            itemCatalog.listItemsInASpecificCategory();
        } else {
            printStream.println("Invalid Selection");
        }
    }

}
