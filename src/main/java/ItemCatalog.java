import java.io.PrintStream;
import java.util.Collection;

public class ItemCatalog {
    private final PrintStream printStream;
    private final UserInput userInput;
    private final Collection<Item> availableGroceryItems;
    private final Collection<Category> availableCategories;

    public ItemCatalog(PrintStream printStream, UserInput userInput, Collection<Item> availableGroceryItems, Collection<Category> availableCategories) {
        this.printStream = printStream;
        this.userInput = userInput;
        this.availableGroceryItems = availableGroceryItems;
        this.availableCategories = availableCategories;
    }

    public void listItems() {
        for(Item item : availableGroceryItems) {
            printStream.println(item.details());
        }
    }

    public void listCategories() {
        for(Category category : availableCategories) {
            printStream.println(category.getTitle());
        }
    }

    public void listItemsInASpecificCategory() {
        printStream.println("Please Enter A Category Of Your Choice");

        String selectedCategory = userInput.getInput();

       for(Item item :availableGroceryItems) {
           if(item.getCategoryName().equals(selectedCategory)) {
               printStream.println(item.details());
           }
       }
    }
}
