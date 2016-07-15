import java.io.PrintStream;

public class Application {
    private final Menu menu;
    private final MenuValidator menuValidator;
    private final PrintStream printStream;
    private final UserInput userInput;

    public Application(Menu menu, MenuValidator menuValidator, PrintStream printStream, UserInput userInput) {
        this.menu = menu;
        this.menuValidator = menuValidator;
        this.printStream = printStream;
        this.userInput = userInput;
    }

    public void start() {
        printStream.println("Welcome to Grocery Dash!");
        String userOption = "";

        do {
            menu.display();
            userOption = userInput.getInput();
            menuValidator.validate(userOption);
        }while(userHasNotQuit(userOption));

    }

    private boolean userHasNotQuit(String userOption) {
        return !userOption.equals("Quit");
    }

}
