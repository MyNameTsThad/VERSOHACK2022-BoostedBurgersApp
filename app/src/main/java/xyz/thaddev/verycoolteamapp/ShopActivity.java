package xyz.thaddev.verycoolteamapp;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

import xyz.thaddev.verycoolteamapp.core.ShoppingCartItem;

public class ShopActivity extends AppCompatActivity {
    CardView CardViewTheChimmyBurburgur;

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Toolbar toolbar = findViewById(R.id.Toolbar);
        toolbar.setTitle("Shop");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        CardViewTheChimmyBurburgur = findViewById(R.id.CardViewTheChimmyBurburgur);

        CardViewTheChimmyBurburgur.setOnClickListener(v -> {
            BottomSheetDialog addToCartDialog = new BottomSheetDialog(ShopActivity.this, R.style.AddToCartDialogTheme);
            View addToCartView = LayoutInflater.from(getApplicationContext()).inflate(
                    R.layout.layout_add_to_cart, findViewById(R.id.addToCartContainer)
            );
            addToCartView.findViewById(R.id.AddToCartButton).setOnClickListener(c -> {
                int ammount = Integer.parseInt(((EditText)addToCartView.findViewById(R.id.AmmountEditText)).getText().toString());
                MainActivity.instance.cart.cart.add(new ShoppingCartItem(xyz.thaddev.verycoolteamapp.core.Menu.menu.get(1), ammount));
                Log.i("submit", MainActivity.instance.cart.toString());
                Toast.makeText(this, "Added " + ammount + " of The Chimmy Burburger to your cart.", Toast.LENGTH_SHORT).show();
                addToCartDialog.dismiss();
            });
            addToCartView.findViewById(R.id.AddButton).setOnClickListener(c -> {
                int ammount = Integer.parseInt(((EditText)addToCartView.findViewById(R.id.AmmountEditText)).getText().toString());
                ((EditText)addToCartView.findViewById(R.id.AmmountEditText)).setText(String.valueOf(ammount + 1));
            });
            addToCartView.findViewById(R.id.RemoveButton).setOnClickListener(c -> {
                int ammount = Integer.parseInt(((EditText)addToCartView.findViewById(R.id.AmmountEditText)).getText().toString());
                ((EditText)addToCartView.findViewById(R.id.AmmountEditText)).setText(String.valueOf(ammount - 1));
            });
            addToCartDialog.setContentView(addToCartView);
            addToCartDialog.show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.shopping_cart_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.shoppingCartMenuItem){
            Intent i = new Intent(this, ShoppingCartActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}