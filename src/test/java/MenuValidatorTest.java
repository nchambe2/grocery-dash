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

    @Before
    public void setUp() {
        itemCatalog = mock(ItemCatalog.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        menuValidator = new MenuValidator(itemCatalog, printStream);

    }

    @Test
    public void shouldListAllAvailableGroceryItemsWhenUserInputIsBrowseItems() {
        menuValidator.validate("Browse Available Items");

        verify(itemCatalog).listItems();
    }

    @Test
    public void shouldListAllAvailableCategoriesWhenUserInputIsBrowseByCategory() {
        menuValidator.validate("Browse Available Categories");

        verify(itemCatalog).listCategories();
    }

    @Test
    public void shouldListAllAvailableItemsInASpecificCategoryWhenUserInputIsBrowseByAvailableCategory() throws IOException {
       when(bufferedReader.readLine()).thenReturn("Category");

        menuValidator.validate("Browse Available Items In A Category");

        verify(itemCatalog).listItemsInASpecificCategory();
    }

    @Test
    public void shouldDisplaySelectionIsInvalidMessageWhenUserInputIsNotBrowseItems() {
        menuValidator.validate("fdsjal");

        verify(printStream).println(contains("Invalid Selection"));
    }

}