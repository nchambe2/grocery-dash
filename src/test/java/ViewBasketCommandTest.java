import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ViewBasketCommandTest {
    @Test
    public void shouldDisplayItemsInTheBasketWhenRun() {
        Basket basket = mock(Basket.class);
        ViewBasketCommand viewBasketCommand = new ViewBasketCommand(basket);

        viewBasketCommand.run();

        verify(basket).display();
    }

}