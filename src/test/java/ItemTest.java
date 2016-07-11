import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemTest {

    private Category category;
    private Item item;

    @Before
    public void setUp() {
        category = mock(Category.class);
        item = new Item("Item Title",
                "Item Description",
                category,
                "Item Price");
    }

    @Test
    public void shouldReturnTitleDescriptionPriceAndCategoryWhenDetailsIsCalled() {
        when(category.getTitle()).thenReturn("Item Category");

        assertThat(item.details(), is("Item Title | " +
                                      "Item Description | " +
                                      "Item Category | " +
                                      "Item Price"));
    }

    @Test
    public void shouldDisplayCategoryNameWhenGetCategoryNameIsCalled() {
        when(category.getTitle()).thenReturn("Item Category");

        assertThat(item.getCategoryName(), is("Item Category"));
    }
}