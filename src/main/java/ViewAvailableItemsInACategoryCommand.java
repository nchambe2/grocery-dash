import java.io.PrintStream;

public class ViewAvailableItemsInACategoryCommand implements Command {

    private final Inventory inventory;
    private final PrintStream printStream;
    private final UserInput userInput;

    public ViewAvailableItemsInACategoryCommand(Inventory inventory, PrintStream printStream, UserInput userInput) {
        this.inventory = inventory;
        this.printStream = printStream;
        this.userInput = userInput;
    }

    @Override
    public void run() {
        printStream.println("Please Enter A Category Of Your Choice");

        String selectedCategory = userInput.getInput();

       inventory.listItemsIn(selectedCategory);
    }
}
