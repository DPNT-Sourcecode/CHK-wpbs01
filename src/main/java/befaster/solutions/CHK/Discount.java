package befaster.solutions.CHK;

public class Discount {
    private Integer quantity;
    private Integer price;
    private Item itemForFree;

    public Discount(Integer quantity, Integer price, Item itemForFree) {
        this.quantity = quantity;
        this.price = price;
        this.itemForFree = itemForFree;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public Item getItemForFree() {
        return itemForFree;
    }
}
