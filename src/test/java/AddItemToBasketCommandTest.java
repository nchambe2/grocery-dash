import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddItemToBasketCommandTest {
    @Test
    public void shouldAddItemToBasketWhenRun() {
        Basket basket = mock(Basket.class);
        AddItemToBasketCommand addItemToBasketCommand = new AddItemToBasketCommand(basket);

        addItemToBasketCommand.run();

        verify(basket).add();
    }
}