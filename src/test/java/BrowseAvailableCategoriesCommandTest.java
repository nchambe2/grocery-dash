import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BrowseAvailableCategoriesCommandTest {
    @Test
    public void shouldListAllAvailableCategoriesWhenCommandIsRun() {
        ItemCatalog itemCatalog = mock(ItemCatalog.class);
        BrowseAvailableCategoriesCommand browseAvailableCategoriesCommand = new BrowseAvailableCategoriesCommand(itemCatalog);

        browseAvailableCategoriesCommand.run();

        verify(itemCatalog).listCategories();
    }

}