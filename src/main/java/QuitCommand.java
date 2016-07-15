import java.io.PrintStream;

public class QuitCommand implements Command {

    private final PrintStream printStream;

    public QuitCommand(PrintStream printStream) {

        this.printStream = printStream;
    }

    @Override
    public void run() {
        printStream.println("Goodbye!");
    }
}
