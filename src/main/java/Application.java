import java.io.PrintStream;

public class Application {
    private final Menu menu;
    private final MenuValidator menuValidator;
    private final PrintStream printStream;

    public Application(Menu menu, MenuValidator menuValidator, PrintStream printStream) {
        this.menu = menu;
        this.menuValidator = menuValidator;
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome to Grocery Dash!");
        menu.display();
        menuValidator.validate();
    }

}
