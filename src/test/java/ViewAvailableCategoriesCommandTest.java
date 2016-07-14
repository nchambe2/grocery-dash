import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ViewAvailableCategoriesCommandTest {

    private GroceryCatalog groceryCatalog;
    private ViewAvailableCategoriesCommand viewAvailableCategoriesCommand;
    private Map<String, String> availableCategories;

    @Before
    public void setUp() {
        groceryCatalog = mock(GroceryCatalog.class);
        availableCategories = new HashMap<>();
        viewAvailableCategoriesCommand = new ViewAvailableCategoriesCommand(groceryCatalog, availableCategories);
    }

    //verify that you print out all the right things
    @Test
    public void shouldListAvailableCategoriesWhenCalled() {
        viewAvailableCategoriesCommand.run();

        verify(groceryCatalog).list(availableCategories);
    }

}