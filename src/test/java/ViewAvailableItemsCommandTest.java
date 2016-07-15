import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ViewAvailableItemsCommandTest {

    private Inventory inventory;
    private ViewAvailableItemsCommand viewAvailableItemsCommand;
    private Map<String, String> availableGroceryItems;

    @Before
    public void setUp() {
        availableGroceryItems = new HashMap<>();
        inventory = mock(Inventory.class);
        viewAvailableItemsCommand = new ViewAvailableItemsCommand(availableGroceryItems, inventory);
    }

    @Test
    public void shouldListAvailableItemsWhenCommandIsRun() {
        viewAvailableItemsCommand.run();

        verify(inventory).list(availableGroceryItems);
    }

}