import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CategoryTest {
    @Test
    public void shouldReturnCategoryTitleWhenGetTitleIsCalled() {
        Category category = new Category("category");

        assertThat(category.getTitle(), is("category"));
    }
}