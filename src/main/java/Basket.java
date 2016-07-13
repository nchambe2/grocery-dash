import java.io.PrintStream;

public class Basket {
    private final PrintStream printStream;

    public Basket(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void display() {
        printStream.println("This basket is empty");
    }

    public void add() {

    }
}
