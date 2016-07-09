import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class ItemCatalogTest {

    private PrintStream printStream;
    private Collection<Item> availableGroceryItems;
    private ItemCatalog itemCatalog;
    private Item itemOne;
    private Item itemTwo;

    @Before
    public void setUp () {
        printStream = mock(PrintStream.class);
        availableGroceryItems = new ArrayList<>();
        itemOne = mock(Item.class);
        itemTwo = mock(Item.class);
        itemCatalog = new ItemCatalog(printStream, availableGroceryItems);

    }

    @Test
    public void shouldDisplayAvailableGroceryItemHeaderWhenListingAvailableGroceryItems() {
        itemCatalog.list();

        verify(printStream).println(contains("Item Name"));
    }


    @Test
    public void shouldDisplayASingleGroceryItemWhenThereAreIsOneAvailableGroceryItem() {
        when(itemOne.getTitle()).thenReturn("Item One");
        availableGroceryItems.add(itemOne);

        itemCatalog.list();

        verify(printStream).println(contains("Item One"));
    }

    @Test
    public void shouldDisplayTwoGroceryItemsWhenThereAreTwoAvailableGroceryItems() {
        when(itemOne.getTitle()).thenReturn("Item One");
        when(itemOne.getTitle()).thenReturn("Item Two");
        availableGroceryItems.add(itemOne);
        availableGroceryItems.add(itemTwo);

        itemCatalog.list();

        verify(printStream).println(contains("Item Two"));
    }
}