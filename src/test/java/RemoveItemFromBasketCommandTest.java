import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RemoveItemFromBasketCommandTest {

    @Test
    public void shouldRemoveItemFromBasketWhenRun() {
        Shopper shopper = mock(Shopper.class);
        RemoveItemFromBasketCommand removeItemFromBasketCommand = new RemoveItemFromBasketCommand(shopper);

        removeItemFromBasketCommand.run();

        verify(shopper).placeItemBackOnShelf();
    }

}