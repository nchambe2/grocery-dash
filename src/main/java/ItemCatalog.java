import java.util.Collection;

public class ItemCatalog {
    private final Collection<Item> availableGroceryItems;
    private final Collection<Category> availableCategories;

    public ItemCatalog(Collection<Item> availableGroceryItems, Collection<Category> availableCategories) {
        this.availableGroceryItems = availableGroceryItems;
        this.availableCategories = availableCategories;
    }

    public Collection<Item> getAvailableGroceryItems() {
        return availableGroceryItems;
    }

    public Collection<Category> getAvailableCategories() {
        return availableCategories;
    }
}
