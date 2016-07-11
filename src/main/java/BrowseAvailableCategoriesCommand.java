public class BrowseAvailableCategoriesCommand implements Command{
    private final ItemCatalog itemCatalog;

    public BrowseAvailableCategoriesCommand(ItemCatalog itemCatalog) {

        this.itemCatalog = itemCatalog;
    }

    @Override
    public void run() {
        itemCatalog.listCategories();
    }
}
