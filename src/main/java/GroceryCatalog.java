import java.io.PrintStream;
import java.util.Collection;

public class GroceryCatalog {
    private final Collection<String> availableGroceryItems;
    private final PrintStream printStream;

    public GroceryCatalog(Collection<String> availableGroceryItems, Collection<String> availableCategories, PrintStream printStream) {
        this.availableGroceryItems = availableGroceryItems;
        this.printStream = printStream;
    }

    //contains
    //return true if you find it in the loop
    //false
    //no local variable
    public Boolean isAvailable(Collection<String> groceryCollection, String title) {

        for(String item : groceryCollection) {
            return item.contains(title);
        }

        return false;
    }

    public void list(Collection<String> groceryCollection) {
        String itemsToDisplay = "";

        for(String item : groceryCollection) {
          itemsToDisplay += item + "\n";
        }

        printStream.println(itemsToDisplay);
    }


    public void listItemsIn(String selectedCategory) {
        String itemsToDisplay = "";

        for(String item : availableGroceryItems) {
            if(item.contains(selectedCategory)) {
                itemsToDisplay += item + "\n";
            }
        }

        printStream.println(itemsToDisplay);
    }
}
