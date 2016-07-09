import java.io.BufferedReader;
import java.io.IOException;

public class Application {
    private final Menu menu;
    private final BufferedReader bufferedReader;

    public Application(Menu menu, BufferedReader bufferedReader) {
        this.menu = menu;
        this.bufferedReader = bufferedReader;
    }

    public void start() {
        menu.display();
        String userInput = getUserInput();
        menu.validate(userInput);
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
