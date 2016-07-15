import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    private Item item;

    @Before
    public void setUp() {
        item = new Item("Title", "Description", "Category", "Price", 10);
    }

    @Test
    public void shouldReturnItemDetailsWhenCalled() {
        assertThat(item.details(), is("Title | Description | Category | Price | 10"));
    }

    @Test
    public void shouldReturnCategoryWhenCalled() {
        assertThat(item.getCategory(), is("Category"));
    }

    @Test
    public void shouldSubtractOneFromQuantityWhenCalled() {
        item.subtractOne();

    }
}