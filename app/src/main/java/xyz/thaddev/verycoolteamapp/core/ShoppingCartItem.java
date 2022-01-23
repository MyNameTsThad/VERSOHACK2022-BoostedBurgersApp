package xyz.thaddev.verycoolteamapp.core;

public class ShoppingCartItem {
    private MenuItem item;
    private int quantity;
    private float price;

    public ShoppingCartItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.price = item.getPrice() * quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public void setItem(MenuItem item) {
        this.item = item;
        this.price = item.getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.price = item.getPrice() * quantity;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "item=" + item +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
