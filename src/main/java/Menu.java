import java.io.PrintStream;
import java.util.Map;

public class Menu {
    private final PrintStream printStream;
    private final Map<String, Command> groceryCommands;

    public Menu(PrintStream printStream, Map<String, Command> groceryCommands) {
        this.printStream = printStream;
        this.groceryCommands = groceryCommands;
    }

    public void display() {
        String commandKeys = "";

        for(Map.Entry<String, Command> command : groceryCommands.entrySet()) {
            commandKeys += command.getKey() + "\n";
        }

        printStream.println(commandKeys);
    }

}
