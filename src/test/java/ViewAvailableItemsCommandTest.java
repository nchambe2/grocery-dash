import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ViewAvailableItemsCommandTest {

    private GroceryCatalog groceryCatalog;
    private ViewAvailableItemsCommand viewAvailableItemsCommand;
    private Map<String, String> availableGroceryItems;

    @Before
    public void setUp() {
        availableGroceryItems = new HashMap<>();
        groceryCatalog = mock(GroceryCatalog.class);
        viewAvailableItemsCommand = new ViewAvailableItemsCommand(availableGroceryItems, groceryCatalog);
    }

    @Test
    public void shouldListAvailableItemsWhenCalled() {
        viewAvailableItemsCommand.run();

        verify(groceryCatalog).list(availableGroceryItems);
    }

}