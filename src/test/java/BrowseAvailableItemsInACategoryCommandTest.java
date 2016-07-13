import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;


public class BrowseAvailableItemsInACategoryCommandTest {

    private GroceryCatalog groceryCatalog;
    private BrowseAvailableItemsInACategoryCommand browseAvailableItemsInACategoryCommand;
    private PrintStream printStream;
    private UserInput userInput;
    private Collection<Item> availableGroceryItems;
    private Item itemOne;
    private Item itemTwo;

    @Before
    public void setUp() {
        groceryCatalog = mock(GroceryCatalog.class);
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        itemOne = mock(Item.class);
        itemTwo = mock(Item.class);
        availableGroceryItems = new ArrayList<>();
        browseAvailableItemsInACategoryCommand = new BrowseAvailableItemsInACategoryCommand(groceryCatalog, printStream, userInput);
    }

    @Test
    public void shouldPromptUserToEnterAnAvailableCategoryWhenListingItemsInASpecificCategory() {
        browseAvailableItemsInACategoryCommand.run();

        verify(printStream).println(contains("Enter A Category"));
    }

    @Test
    public void shouldGetSelectedCategoryWhenGettingUserInput() {
        browseAvailableItemsInACategoryCommand.run();

        verify(userInput).getInput();
    }

    @Test
    public void shouldListASingleItemWhenThereIsOneItemAvailablInACategory() {
        when(userInput.getInput()).thenReturn("Category");
        when(groceryCatalog.getAvailableGroceryItems()).thenReturn(availableGroceryItems);
        when(itemOne.details()).thenReturn("Category");
        availableGroceryItems.add(itemOne);

        browseAvailableItemsInACategoryCommand.run();

        verify(printStream, times(2)).println(contains("Category"));
    }

    @Test
    public void shouldListTwoItemsWhenThereAreMultipleitemsAvailableInACategory() {
        when(userInput.getInput()).thenReturn("Category");
        when(groceryCatalog.getAvailableGroceryItems()).thenReturn(availableGroceryItems);
        when(itemOne.details()).thenReturn("Category");
        when(itemTwo.details()).thenReturn("Category");
        availableGroceryItems.add(itemOne);
        availableGroceryItems.add(itemTwo);

        browseAvailableItemsInACategoryCommand.run();

        verify(printStream, times(3)).println(contains("Category"));
    }
}