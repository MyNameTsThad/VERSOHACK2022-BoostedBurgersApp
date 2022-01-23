package xyz.thaddev.verycoolteamapp;

import android.annotation.SuppressLint;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;

import xyz.thaddev.verycoolteamapp.core.ShoppingCart;

public class MainActivity extends AppCompatActivity {
    CardView CardViewShop;
    CardView CardViewWork;

    public static MainActivity instance;
    public ShoppingCart cart;

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        cart = new ShoppingCart();
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.Toolbar);
        toolbar.setTitle("Boosted Burgers");
        setSupportActionBar(toolbar);

        CardViewShop = findViewById(R.id.CardViewShop);
        CardViewWork = findViewById(R.id.CardViewWorkWithUS);

        CardViewShop.setOnClickListener(v -> {
            Intent i = new Intent(this, ShopActivity.class);
            startActivity(i);
        });
    }
}