import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BrowseAvailableItemsInACategoryCommandTest {
    @Test
    public void shouldListAllAvailableCategoriesWhenUserInputIsBrowseByCategory() {
        ItemCatalog itemCatalog = mock(ItemCatalog.class);
        BrowseAvailableItemsInACategoryCommand browseAvailableItemsInACategoryCommand = new BrowseAvailableItemsInACategoryCommand(itemCatalog);

        browseAvailableItemsInACategoryCommand.run();

        verify(itemCatalog).listItemsInASpecificCategory();
    }
}