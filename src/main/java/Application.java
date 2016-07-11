import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Application {
    private final Menu menu;
    private final MenuValidator menuValidator;
    private final BufferedReader bufferedReader;
    private final PrintStream printStream;

    public Application(Menu menu, MenuValidator menuValidator, BufferedReader bufferedReader, PrintStream printStream) {
        this.menu = menu;
        this.menuValidator = menuValidator;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome to Grocery Dash!");
        menu.display();
        String userInput = getUserInput();
        menuValidator.validate(userInput);
    }

    private String getUserInput() {
        String userInput = "";
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInput;
    }
}
