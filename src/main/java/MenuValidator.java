import java.io.PrintStream;

public class MenuValidator {
    private final ItemCatalog itemCatalog;
    private final PrintStream printStream;

    public MenuValidator(ItemCatalog itemCatalog, PrintStream printStream) {

        this.itemCatalog = itemCatalog;
        this.printStream = printStream;
    }

    public void validate(String userInput) {
        if(userInput.equals("Browse by Items")) {
            itemCatalog.list();
        } else {
            printStream.println("Invalid Selection");
        }
    }
}
