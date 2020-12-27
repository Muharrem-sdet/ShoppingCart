package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoppingActivity extends AppCompatActivity {

    public static final String SENDING_ITEM_NAME_KEY = "com.example.shoppingcart.ShoppingActivity";

    Button itemButton_1, itemButton_2, itemButton_3, itemButton_4, itemButton_5, itemButton_6;
    Button itemButton_7, itemButton_8, itemButton_9, itemButton_10, itemButton_11, itemButton_12;
    Button itemButton_13, itemButton_14, itemButton_15, itemButton_16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        initializeAllTheItemButtons();
        setAllOnClickItemButtonListeners();

    }

    public void onItemButtonClick(View view) {
        Button itemButton = (Button)view;
        String itemName = itemButton.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(SENDING_ITEM_NAME_KEY, itemName);
        int resultCode;
        if(MainActivity.counter >= 10) {
            resultCode = RESULT_CANCELED;
        } else {
            resultCode = RESULT_OK;
        }
        setResult(resultCode, intent);
        finish();
    }

    public void initializeAllTheItemButtons() {
        itemButton_1 = findViewById(R.id.button_item_1);
        itemButton_2 = findViewById(R.id.button_item_2);
        itemButton_3 = findViewById(R.id.button_item_3);
        itemButton_4 = findViewById(R.id.button_item_4);
        itemButton_5 = findViewById(R.id.button_item_5);
        itemButton_6 = findViewById(R.id.button_item_6);
        itemButton_7 = findViewById(R.id.button_item_7);
        itemButton_8 = findViewById(R.id.button_item_8);
        itemButton_9 = findViewById(R.id.button_item_9);
        itemButton_10 = findViewById(R.id.button_item_10);
        itemButton_11 = findViewById(R.id.button_item_11);
        itemButton_12 = findViewById(R.id.button_item_12);
        itemButton_13 = findViewById(R.id.button_item_13);
        itemButton_14 = findViewById(R.id.button_item_14);
        itemButton_15 = findViewById(R.id.button_item_15);
        itemButton_16 = findViewById(R.id.button_item_16);
    }

    public void setAllOnClickItemButtonListeners(){
        itemButton_1.setOnClickListener(this::onItemButtonClick);
        itemButton_2.setOnClickListener(this::onItemButtonClick);
        itemButton_3.setOnClickListener(this::onItemButtonClick);
        itemButton_4.setOnClickListener(this::onItemButtonClick);
        itemButton_5.setOnClickListener(this::onItemButtonClick);
        itemButton_6.setOnClickListener(this::onItemButtonClick);
        itemButton_7.setOnClickListener(this::onItemButtonClick);
        itemButton_8.setOnClickListener(this::onItemButtonClick);
        itemButton_9.setOnClickListener(this::onItemButtonClick);
        itemButton_10.setOnClickListener(this::onItemButtonClick);
        itemButton_11.setOnClickListener(this::onItemButtonClick);
        itemButton_12.setOnClickListener(this::onItemButtonClick);
        itemButton_13.setOnClickListener(this::onItemButtonClick);
        itemButton_14.setOnClickListener(this::onItemButtonClick);
        itemButton_15.setOnClickListener(this::onItemButtonClick);
        itemButton_16.setOnClickListener(this::onItemButtonClick);
    }
}