import java.io.BufferedReader;
import java.io.IOException;

public class Application {
    private final Menu menu;
    private final MenuValidator menuValidator;
    private final BufferedReader bufferedReader;

    public Application(Menu menu, MenuValidator menuValidator, BufferedReader bufferedReader) {
        this.menu = menu;
        this.menuValidator = menuValidator;
        this.bufferedReader = bufferedReader;
    }

    public void start() {
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
