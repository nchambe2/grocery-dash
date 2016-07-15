import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShopperTest {

    private PrintStream printStream;
    private UserInput userInput;
    private Shopper shopper;
    private Basket basket;
    private Inventory inventory;
    private Map<String, String> availableGroceryItems;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        basket = mock(Basket.class);
        inventory = mock(Inventory.class);
        availableGroceryItems = new HashMap<>();
        shopper = new Shopper(printStream, userInput, basket, inventory);
    }

    @Test
    public void shouldPromptUserToEnterNameOfItemWhenShopping() {
        shopper.shop();

        verify(printStream).println(contains("item number that corresponds with the item you would like to add to your basket"));
    }

    @Test
    public void shouldGetItemToAddToBasketWhenUserHasBeenPrompted() {
        shopper.shop();

        verify(userInput).getInput();
    }

    @Test
    public void shouldMoveItemToBasketWhenItemIsInStock() {
        when(userInput.getInput()).thenReturn("1");
        when(inventory.isItemInStock("1")).thenReturn(true);

        shopper.shop();

        verify(inventory).addItemToItemsToBePurchased("1");
    }


    @Test
    public void shouldDisplayItemNotInStockMessageWhenItemIsNotInStock() {
        when(userInput.getInput()).thenReturn("5");
        availableGroceryItems.put("1", "Title | Description | Category One | Price");

        shopper.shop();

        verify(printStream).println(contains("Item is not in stock"));
    }

    @Test
    public void shouldPromptUserToSelectItemToPlaceBackOnShelfWhenCalled() {
        shopper.placeItemBackOnShelf();

       verify(printStream).println(contains("select item to place on shelf"));
    }

    @Test
    public void shouldGetItemToPlaceOnShelfWhenUserHasBeenPrompted() {
        shopper.placeItemBackOnShelf();

        verify(userInput).getInput();
    }

    @Test
    public void shouldReturnItemToInventoryWhenItemIsInBasket() {
        when(userInput.getInput()).thenReturn("1");
        when(basket.isItemInBasket("1")).thenReturn(true);

        shopper.placeItemBackOnShelf();

        verify(basket).returnToInventory("1");
    }

    @Test
    public void shouldDisplayUnableToAddToInventoryMessageWhenItemIsNotInBasket() {
        when(userInput.getInput()).thenReturn("Item Key");
        when(basket.isItemInBasket("Incorrect Item Key")).thenReturn(false);

        shopper.placeItemBackOnShelf();

        verify(printStream).println(contains("can not be added to inventory"));
    }

}