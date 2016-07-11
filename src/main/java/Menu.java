import java.io.PrintStream;

public class Menu {
    private final PrintStream printStream;

    public Menu(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void display() {
        printStream.println("Select From The Following Options:\n" +
                            "Browse Available Items\n" +
                            "Browse Available Categories\n" +
                            "Browse Available Items In A Category");
    }

}
