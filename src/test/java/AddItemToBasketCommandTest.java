import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddItemToBasketCommandTest {

    @Test
    public void shouldValidateItemBeingAdddedToTheBaskedWhenRun() {
        GroceryCatalog groceryCatalog = mock(GroceryCatalog.class);
        AddItemToBasketCommand addItemToBasketCommand = new AddItemToBasketCommand(groceryCatalog);

        addItemToBasketCommand.run();

        verify(groceryCatalog).shop();
    }
}