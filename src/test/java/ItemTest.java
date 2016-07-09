import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void shouldReturnItemTitleWhenGetterIsCalled() {
        Item item = new Item("Item Title",
                             "Item Description",
                             "Item Category",
                             "Item Title");

        assertThat(item.getTitle(), is("Item Title"));
    }

    @Test
    public void shouldReturnTitleDescriptionPriceAndCategoryWhenDetailsIsCalled() {
        Item item = new Item("Item Title",
                             "Item Description",
                             "Item Category",
                             "Item Title");

        assertThat(item.details(), is("Item Title, " +
                                      "Item Description," +
                                      " Item Category, " +
                                      "Item Title"));
    }
}