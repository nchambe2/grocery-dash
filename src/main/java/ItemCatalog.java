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

    public Boolean findItem(String itemTitle) {
        Boolean isItemContainedInCatalog = false;

        for(Item item : availableGroceryItems) {
            isItemContainedInCatalog =  item.details().contains(itemTitle);
        }

        return isItemContainedInCatalog;
    }

    public Boolean findCategory(Category category) {
        return availableCategories.contains(category);
    }
}
