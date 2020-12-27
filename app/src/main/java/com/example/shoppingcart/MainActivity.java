package com.example.shoppingcart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewList;
    private Button buttonContinueShopping;
    private final int SHOPPING_REQUEST_CODE = 1;
    private String finalListText = "";
    public static int counter;
    private String LOG_TAG = "MainActivity Log";
    private String EXTRA_COUNTER = "For adding counter value to the outState bundle";
    private String EXTRA_VIEW_TEXT = "For adding text of tv_list to the outState bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewList = findViewById(R.id.item_1);
        buttonContinueShopping = findViewById(R.id.shopping_button);

        buttonContinueShopping.setOnClickListener(view -> onShoppingButtonClick());
        if (savedInstanceState != null) {
            finalListText = savedInstanceState.getString(EXTRA_VIEW_TEXT);
            counter = savedInstanceState.getInt(EXTRA_COUNTER);
            textViewList.setText(finalListText);
            textViewList.setVisibility(View.VISIBLE);
        } else {
            Log.d(LOG_TAG, "savedInstanceState is null");
        }

    }

    public void onShoppingButtonClick() {
        Intent intent = new Intent(this, ShoppingActivity.class);
        startActivityForResult(intent, SHOPPING_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == SHOPPING_REQUEST_CODE) {
                if (resultCode == RESULT_OK) {
                    String retrievedItemName = data.getStringExtra(ShoppingActivity.SENDING_ITEM_NAME_KEY);
                    counter++;
                    finalListText = finalListText.concat(counter + ". ").concat(retrievedItemName).concat("\n");
                    textViewList.setText(finalListText);
                    textViewList.setVisibility(View.VISIBLE);
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, "You cannot order more than 10 items at a time.", Toast.LENGTH_LONG).show();
                }
            } else {
                Log.d(LOG_TAG, "Unexpected SHOPPING_REQUEST_CODE");
            }
        } else {
            Log.d(LOG_TAG, "data intent onActivityResult is null");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_COUNTER, counter);
        outState.putString(EXTRA_VIEW_TEXT, finalListText);
    }
}