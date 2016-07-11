public class Item {
    private final String title;
    private final String description;
    private final Category category;
    private final String price;

    public Item(String title, String description, Category category, String price) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String details() {
        return String.join(" | " , title, description, category.getTitle(), price);
    }

    //problematic getter
    public String getCategoryName() {
        return category.getTitle();
    }
}
