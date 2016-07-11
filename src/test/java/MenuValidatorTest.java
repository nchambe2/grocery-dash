import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuValidatorTest {

    private ItemCatalog itemCatalog;
    private PrintStream printStream;
    private MenuValidator menuValidator;
    private BufferedReader bufferedReader;
    private UserInput userInput;

    @Before
    public void setUp() {
        itemCatalog = mock(ItemCatalog.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        userInput = mock(UserInput.class);
        menuValidator = new MenuValidator(itemCatalog, printStream, userInput);

    }

    @Test
    public void shouldListAllAvailableGroceryItemsWhenUserInputIsBrowseItems() {
        when(userInput.getInput()).thenReturn("Browse Available Items");

        menuValidator.validate();

        verify(itemCatalog).listItems();
    }

    @Test
    public void shouldListAllAvailableCategoriesWhenUserInputIsBrowseByCategory() {
        when(userInput.getInput()).thenReturn("Browse Available Categories");

        menuValidator.validate();

        verify(itemCatalog).listCategories();
    }

    @Test
    public void shouldListAllAvailableItemsInASpecificCategoryWhenUserInputIsBrowseByAvailableCategory() throws IOException {
        when(userInput.getInput()).thenReturn("Browse Available Items In A Category");

        menuValidator.validate();

        verify(itemCatalog).listItemsInASpecificCategory();
    }

    @Test
    public void shouldDisplaySelectionIsInvalidMessageWhenUserInputIsNotBrowseItems() {
        when(userInput.getInput()).thenReturn("jfdskl");

        menuValidator.validate();

        verify(printStream).println(contains("Invalid Selection"));
    }

}