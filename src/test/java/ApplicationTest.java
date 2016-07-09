import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {


    @Test
    public void shouldDisplayAllAvailableItemsInTheGroceryStoreWhenApplicationStarts () {
        ItemCatalog itemCatalog = mock(ItemCatalog.class);
        Application application = new Application(itemCatalog);

        application.start();

        verify(itemCatalog).list();
    }
}