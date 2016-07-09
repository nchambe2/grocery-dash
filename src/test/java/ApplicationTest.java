import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {


    @Test
    public void shouldDisplayAllAvailableItemsInTheGroceryStoreWhenApplicationStarts () {
        ItemCatalog itemCatalog = mock(ItemCatalog.class);
        MenuX menux = mock(MenuX.class);
        Application application = new Application(itemCatalog, menux);

        application.start();

        verify(itemCatalog).list();
    }

    @Test
    public void shouldDisplayMenuOptionWhenApplicationStarts() {
        ItemCatalog itemCatalog = mock(ItemCatalog.class);
        MenuX menux = mock(MenuX.class);
        Application application = new Application(itemCatalog, menux);

        application.start();

        verify(menux).display();
    }
}

