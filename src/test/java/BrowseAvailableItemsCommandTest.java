import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BrowseAvailableItemsCommandTest {

    @Test
    public void shouldListAvailableGroceryItemsWhenCommandIsRun() {
        ItemCatalog itemCatalog = mock(ItemCatalog.class);
        BrowseAvailableItemsCommand browseAvailableItemsCommand = new BrowseAvailableItemsCommand(itemCatalog);

        browseAvailableItemsCommand.run();

        verify(itemCatalog).listItems();
    }
}