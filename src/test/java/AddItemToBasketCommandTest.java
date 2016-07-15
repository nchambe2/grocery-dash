import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddItemToBasketCommandTest {

    @Test
    public void shouldShopWhenCommandIsCalled() {
        Shopper shopper = mock(Shopper.class);
        AddItemToBasketCommand addItemToBasketCommand = new AddItemToBasketCommand(shopper);

        addItemToBasketCommand.run();

        verify(shopper).shop();
    }
}