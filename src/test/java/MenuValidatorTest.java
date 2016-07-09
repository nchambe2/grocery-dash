import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuValidatorTest {

    private ItemCatalog itemCatalog;
    private PrintStream printStream;
    private MenuValidator menuValidator;

    @Before
    public void setUp() {
        itemCatalog = mock(ItemCatalog.class);
        printStream = mock(PrintStream.class);
        menuValidator = new MenuValidator(itemCatalog, printStream);

    }

    @Test
    public void shouldListAllAvailableGroceryItemsWhenUserInputIsBrowseItems() {
        menuValidator.validate("Browse by Items");

        verify(itemCatalog).list();
    }

    @Test
    public void shouldDisplaySelectionIsInvalidMessageWhenUserInputIsNotBrowseItems() {
        menuValidator.validate("fdsjal");

        verify(printStream).println(contains("Invalid Selection"));
    }
}