import java.io.PrintStream;

public class Menu {
    private final PrintStream printStream;
    private final ItemCatalog itemCatalog;

    public Menu(PrintStream printStream, ItemCatalog itemCatalog) {

        this.printStream = printStream;
        this.itemCatalog = itemCatalog;
    }

    public void display() {
        printStream.println("Browse by Items");
    }

    public void validate(String userInput) {
        if(userInput.equals("Browse by Items")) {
            itemCatalog.list();
        } else {
            printStream.println("Invalid Selection");
        }
    }
}
