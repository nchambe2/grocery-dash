import java.io.PrintStream;

public class Menu {
    private final PrintStream printStream;

    public Menu(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void display() {
        printStream.println("Browse by Items");
    }

}
