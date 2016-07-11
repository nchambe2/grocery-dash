import java.io.PrintStream;
import java.util.Map;

public class MenuValidator {
    private final PrintStream printStream;
    private final UserInput userInput;
    private final Map<String, Command> groceryCommands;

    public MenuValidator(PrintStream printStream, UserInput userInput, Map<String, Command> groceryCommands) {

        this.printStream = printStream;
        this.userInput = userInput;
        this.groceryCommands = groceryCommands;
    }


    public void validate() {
        String menuSelection = userInput.getInput();

        if(groceryCommands.containsKey(menuSelection)) {
            groceryCommands.get(menuSelection).run();
        } else {
            printStream.println("Invalid Selection");
        }

    }

}
