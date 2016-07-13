import java.util.Collection;

public class GroceryCatalog {
    private final Collection<Item> availableGroceryItems;
    private final Collection<String> availableCategories;

    public GroceryCatalog(Collection<Item> availableGroceryItems, Collection<String> availableCategories) {
        this.availableGroceryItems = availableGroceryItems;
        this.availableCategories = availableCategories;
    }

    public Collection<Item> getAvailableGroceryItems() {
        return availableGroceryItems;
    }

    public Collection<String> getAvailableCategories() {
        return availableCategories;
    }

    //contains
    //return true if you find it in the loop
    //false
    //no local variable
    public Boolean findItem(String itemTitle) {
        Boolean isItemContainedInCatalog = false;

        for(Item item : availableGroceryItems) {
            isItemContainedInCatalog =  item.details().contains(itemTitle);
        }

        return isItemContainedInCatalog;
    }


    public Boolean findCategory(String categoryTitle) {
        Boolean isCategoryContainedInCatalog = false;

        for(String category : availableCategories) {
            isCategoryContainedInCatalog =  category.equals(categoryTitle);
        }

        return isCategoryContainedInCatalog;
    }
}
