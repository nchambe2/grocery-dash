import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class ItemCatalogTest {

    private PrintStream printStream;
    private List<String> availableGroceryItems;
    private ItemCatalog itemCatalog;

    @Before
    public void setUp () {
        printStream = mock(PrintStream.class);
        availableGroceryItems = new ArrayList<>();
        itemCatalog = new ItemCatalog(printStream, availableGroceryItems);

    }

    @Test
    public void shouldDisplayAvailableGroceryItemHeaderWhenListingAvailableGroceryItems() {
        itemCatalog.list();

        verify(printStream).println(contains("Item Name"));
    }


    @Test
    public void shouldDisplayASingleGroceryItemWhenThereAreIsOneAvailableGroceryItem() {
        availableGroceryItems.add("Item One");

        itemCatalog.list();

        verify(printStream).println(contains("Item One"));
    }

    @Test
    public void shouldDisplayTwoGroceryItemsWhenThereAreTwoAvailableGroceryItems() {
        availableGroceryItems.add("Item One");
        availableGroceryItems.add("Item Two");

        itemCatalog.list();

        verify(printStream).println(contains("Item Two"));
    }
}