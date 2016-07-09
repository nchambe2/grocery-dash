import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private PrintStream printStream;
    private ItemCatalog itemCatalog;
    private Menu menu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        itemCatalog = mock(ItemCatalog.class);
        menu = new Menu(printStream, itemCatalog);
    }

    @Test
    public void shouldDisplayBrowseByItemsAsAnOptionWhenMenuIsDisplayed() {
        menu.display();

        verify(printStream).println(contains("Browse by Items"));
    }

    @Test
    public void shouldListAllAvailableGroceryItemsWhenUserInputIsBrowseItems() {
        menu.validate("Browse by Items");

        verify(itemCatalog).list();
    }

    @Test
    public void shouldDisplaySelectionIsInvalidMessageWhenUserInputIsNotBrowseItems() {
        menu.validate("dfjslj");

        verify(printStream).println(contains("Invalid Selection"));
    }
}