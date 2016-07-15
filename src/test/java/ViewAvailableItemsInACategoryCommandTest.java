import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;


public class ViewAvailableItemsInACategoryCommandTest {

    private Inventory inventory;
    private ViewAvailableItemsInACategoryCommand viewAvailableItemsInACategoryCommand;
    private PrintStream printStream;
    private UserInput userInput;

    @Before
    public void setUp() {
        inventory = mock(Inventory.class);
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        viewAvailableItemsInACategoryCommand = new ViewAvailableItemsInACategoryCommand(inventory, printStream, userInput);
    }

    @Test
    public void shouldPromptUserToEnterACategoryWhenListingItemsInASpecificCategory() {
        viewAvailableItemsInACategoryCommand.run();

        verify(printStream).println(contains("Enter A Category"));
    }

    @Test
    public void shouldGetCategoryUserSelectsWhenPromptHasBeenDisplayed() {
        viewAvailableItemsInACategoryCommand.run();

        verify(userInput).getInput();
    }

    @Test
    public void shouldListItemsInACategorWhenCommandIsCalled() {
        when(userInput.getInput()).thenReturn("Category");

        viewAvailableItemsInACategoryCommand.run();

        verify(inventory).listItemsIn("Category");
    }

}