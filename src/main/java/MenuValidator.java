import java.io.PrintStream;
import java.util.Map;

public class MenuValidator {
    private final PrintStream printStream;
    private final Map<String, Command> groceryCommands;

    public MenuValidator(PrintStream printStream, Map<String, Command> groceryCommands) {

        this.printStream = printStream;
        this.groceryCommands = groceryCommands;
    }

    public void validate(String menuKey) {
        if(isGroceryCommand(menuKey)) {
            groceryCommands.get(menuKey).run();
        } else {
            printStream.println("Invalid Selection");
        }

    }

    private boolean isGroceryCommand(String menuSelection) {
        return groceryCommands.containsKey(menuSelection);
    }

}
