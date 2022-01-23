package xyz.thaddev.verycoolteamapp.core;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static List<MenuItem> menu = new ArrayList<>();
    static {
        menu.add(new MenuItem("Boosted Burger", 80));
        menu.add(new MenuItem("The Chimmy Burburgur", 100));
        menu.add(new MenuItem("Fries", 30));
        menu.add(new MenuItem("Water", 10));
    }
}