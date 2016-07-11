import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemTest {

    @Test
    public void shouldReturnTitleDescriptionPriceAndCategoryWhenDetailsIsCalled() {
        Category category = mock(Category.class);
        when(category.getTitle()).thenReturn("Item Category");
        Item item = new Item("Item Title",
                             "Item Description",
                             category,
                             "Item Price");

        assertThat(item.details(), is("Item Title | " +
                                      "Item Description | " +
                                      "Item Category | " +
                                      "Item Price"));
    }
}