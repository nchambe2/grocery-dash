import java.io.PrintStream;

public class ViewAvailableItemsInACategoryCommand implements Command {

    private final GroceryCatalog groceryCatalog;
    private final PrintStream printStream;
    private final UserInput userInput;

    public ViewAvailableItemsInACategoryCommand(GroceryCatalog groceryCatalog, PrintStream printStream, UserInput userInput) {
        this.groceryCatalog = groceryCatalog;
        this.printStream = printStream;
        this.userInput = userInput;
    }

    @Override
    public void run() {
        printStream.println("Please Enter A Category Of Your Choice");

        String selectedCategory = userInput.getInput();

       groceryCatalog.listItemsIn(selectedCategory);
    }
}
