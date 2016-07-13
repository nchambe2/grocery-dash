import java.io.PrintStream;

public class BrowseAvailableItemsInACategoryCommand implements Command {

    private final GroceryCatalog groceryCatalog;
    private final PrintStream printStream;
    private final UserInput userInput;

    public BrowseAvailableItemsInACategoryCommand(GroceryCatalog groceryCatalog, PrintStream printStream, UserInput userInput) {

        this.groceryCatalog = groceryCatalog;
        this.printStream = printStream;
        this.userInput = userInput;
    }

    @Override
    public void run() {
        printStream.println("Please Enter A Category Of Your Choice");

        String selectedCategory = userInput.getInput();

        for(Item item : groceryCatalog.getAvailableGroceryItems()) {
            if(isItemInSelectedCategory(selectedCategory, item)) {
                printStream.println(item.details());
            }
        }
    }

    private boolean isItemInSelectedCategory(String selectedCategory, Item item) {
        return item.details().contains(selectedCategory);
    }
}
