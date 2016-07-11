import java.io.PrintStream;

public class Application {
    private final Menu menu;
    private final MenuValidator menuValidator;
    private final UserInput userInput;
    private final PrintStream printStream;

    public Application(Menu menu, MenuValidator menuValidator, UserInput userInput, PrintStream printStream) {
        this.menu = menu;
        this.menuValidator = menuValidator;
        this.userInput = userInput;
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome to Grocery Dash!");
        menu.display();
        String userMenuSelection = userInput.getInput();
        menuValidator.validate(userMenuSelection);
    }

}
