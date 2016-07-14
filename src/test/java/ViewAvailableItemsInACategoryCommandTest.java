import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;


public class ViewAvailableItemsInACategoryCommandTest {

    private GroceryCatalog groceryCatalog;
    private ViewAvailableItemsInACategoryCommand viewAvailableItemsInACategoryCommand;
    private PrintStream printStream;
    private UserInput userInput;

    @Before
    public void setUp() {
        groceryCatalog = mock(GroceryCatalog.class);
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        viewAvailableItemsInACategoryCommand = new ViewAvailableItemsInACategoryCommand(groceryCatalog, printStream, userInput);
    }

    @Test
    public void shouldPromptUserToEnterAnAvailableCategoryWhenListingItemsInASpecificCategory() {
        viewAvailableItemsInACategoryCommand.run();

        verify(printStream).println(contains("Enter A Category"));
    }

    @Test
    public void shouldGetSelectedCategoryWhenGettingUserInput() {
        viewAvailableItemsInACategoryCommand.run();

        verify(userInput).getInput();
    }

    @Test
    public void shouldListItemsInACategorWhenCalled() {
        when(userInput.getInput()).thenReturn("Category");

        viewAvailableItemsInACategoryCommand.run();

        verify(groceryCatalog).listItemsIn("Category");
    }

}