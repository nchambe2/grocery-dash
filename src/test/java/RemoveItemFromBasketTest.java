import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RemoveItemFromBasketTest {

    @Test
    public void shouldRemoveItemFromBasketWhenRun() {
        Shopper shopper = mock(Shopper.class);
        RemoveItemFromBasket removeItemFromBasket = new RemoveItemFromBasket(shopper);

        removeItemFromBasket.run();

        verify(shopper).placeItemBackOnShelf();
    }

}