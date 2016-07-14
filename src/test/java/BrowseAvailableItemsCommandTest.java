import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BrowseAvailableItemsCommandTest {

    private GroceryCatalog groceryCatalog;
    private ViewAvailableItemsCommand viewAvailableItemsCommand;
    private Collection<String> availableGroceryItems;

    @Before
    public void setUp() {
        availableGroceryItems = new ArrayList();
        groceryCatalog = mock(GroceryCatalog.class);
        viewAvailableItemsCommand = new ViewAvailableItemsCommand(availableGroceryItems, groceryCatalog);
    }

    @Test
    public void shouldListAvailableItemsWhenCalled() {
        viewAvailableItemsCommand.run();

        verify(groceryCatalog).list(availableGroceryItems);
    }

}