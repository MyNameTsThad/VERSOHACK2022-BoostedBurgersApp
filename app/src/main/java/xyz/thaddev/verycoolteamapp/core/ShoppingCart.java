package xyz.thaddev.verycoolteamapp.core;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public List<ShoppingCartItem> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public float getTotalPrice(){
        float price = 0;
        for (ShoppingCartItem item: cart) {
            price += item.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("ShoppingCart{" +
                "cart=");
        for (ShoppingCartItem item : cart) {
            returnString.append(item.toString());
        }
        returnString.append("}");
        return returnString.toString();
    }
}
