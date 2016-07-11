public class BrowseAvailableItemsCommand implements Command{
    private final ItemCatalog itemCatalog;

    public BrowseAvailableItemsCommand(ItemCatalog itemCatalog) {

        this.itemCatalog = itemCatalog;
    }

    @Override
    public void run() {
        itemCatalog.listItems();
    }
}
