import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShopperTest {

    private PrintStream printStream;
    private UserInput userInput;
    private Shopper shopper;
    private Basket basket;
    private GroceryCatalog groceryCatalog;
    private String item;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        basket = mock(Basket.class);
        groceryCatalog = mock(GroceryCatalog.class);
        shopper = new Shopper(printStream, userInput, basket, groceryCatalog);
    }

    @Test
    public void shouldPromptUserToSelectAnItemWhenPlacingAnItemBackOnShelf() {
        shopper.placeItemBackOnShelf();

       verify(printStream).println(contains("select item to place on shelf"));
    }

    @Test
    public void shouldGetUserInputWhenPlacingAnItemBackOnShelf() {
        shopper.placeItemBackOnShelf();

        verify(userInput).getInput();
    }

    @Test
    public void shouldRemoveItemFromBasketWhenItemSelectedIsCurrentlyInTheBasket() {
        when(userInput.getInput()).thenReturn("Item");
        when(basket.isItemInBasket("Item")).thenReturn(true);

        shopper.placeItemBackOnShelf();

        verify(basket).remove("Item");
    }

    @Test
    public void shouldAddItemToBasketWhenItemSelectedHasBeenRemovedFromBasket() {
        when(userInput.getInput()).thenReturn("Item");
        when(basket.isItemInBasket("Item")).thenReturn(true);

        shopper.placeItemBackOnShelf();

        verify(groceryCatalog).addAvailableItem("Item");
    }

    @Test
    public void shouldDisplayUnableToStockMessageWhenItemIsNotInBasket() {
        when(userInput.getInput()).thenReturn("Item");
        when(basket.isItemInBasket("Item")).thenReturn(false);

        shopper.placeItemBackOnShelf();

        verify(printStream).println(contains("can not be stocked"));
    }
}