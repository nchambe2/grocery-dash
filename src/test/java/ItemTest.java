import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void shouldReturnItemTitleWhenGetterIsCalled() {
        Item item = new Item("Item Title");

        assertThat(item.getTitle(), is("Item Title"));
    }
}