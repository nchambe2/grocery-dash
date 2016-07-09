import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationXTest {
    @Test
    public void shouldDisplayAllAvailableItemsInTheGroceryStoreWhenApplicationStarts () {
        ItemCatalog itemCatalog = mock(ItemCatalog.class);
        ApplicationX applicationX = new ApplicationX(itemCatalog);

        applicationX.start();

        verify(itemCatalog).list();
    }
}