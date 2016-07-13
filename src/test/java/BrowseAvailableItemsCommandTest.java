import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BrowseAvailableItemsCommandTest {

    private ItemCatalog itemCatalog;
    private BrowseAvailableItemsCommand browseAvailableItemsCommand;
    private PrintStream printStream;
    private Collection<Item> availableGroceryItems;
    private Item itemOne;
    private Item itemTwo;

    @Before
    public void setUp() {
        itemCatalog = mock(ItemCatalog.class);
        printStream = mock(PrintStream.class);
        itemOne = mock(Item.class);
        itemTwo = mock(Item.class);
        availableGroceryItems = new ArrayList();
        browseAvailableItemsCommand = new BrowseAvailableItemsCommand(itemCatalog, printStream);
    }

    @Test
    public void shouldDisplayASingleGroceryItemWhenThereIsOneAvailableGroceryItem() {
        availableGroceryItems.add(itemOne);
        when(itemOne.details()).thenReturn("Details");
        when(itemCatalog.getAvailableGroceryItems()).thenReturn(availableGroceryItems);

        browseAvailableItemsCommand.run();

        verify(printStream).println(contains("Details"));
    }

    @Test
    public void shouldDisplayTwoGroceryItemWhenThereAreMultipleAvailableGroceryItems() {
        availableGroceryItems.add(itemOne);
        availableGroceryItems.add(itemTwo);
        when(itemOne.details()).thenReturn("Details One");
        when(itemTwo.details()).thenReturn("Details Two");
        when(itemCatalog.getAvailableGroceryItems()).thenReturn(availableGroceryItems);

        browseAvailableItemsCommand.run();

        verify(printStream).println(contains("Details One"));
        verify(printStream).println(contains("Details Two"));
    }
}