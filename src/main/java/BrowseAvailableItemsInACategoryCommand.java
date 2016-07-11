public class BrowseAvailableItemsInACategoryCommand implements Command {

    private final ItemCatalog itemCatalog;

    public BrowseAvailableItemsInACategoryCommand(ItemCatalog itemCatalog) {

        this.itemCatalog = itemCatalog;
    }

    @Override
    public void run() {
        itemCatalog.listItemsInASpecificCategory();
    }
}
