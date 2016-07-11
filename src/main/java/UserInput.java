import java.io.BufferedReader;
import java.io.IOException;

public class UserInput {

    private final BufferedReader bufferedReader;

    public UserInput(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public String getInput() {
        String userInput = "";
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInput;
    }
}
