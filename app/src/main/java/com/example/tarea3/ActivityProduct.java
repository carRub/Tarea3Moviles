package com.example.tarea3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;


import com.example.tarea3.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity {

    ImageView image;
    TextView name, store, location, phone;
    Button save, cancel;


    ItemProduct item;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        item = getIntent().getParcelableExtra("ITEM");

        image = (ImageView) findViewById(R.id.activity_product_image);
        name = (TextView) findViewById(R.id.activity_product_name);
        store = (TextView) findViewById(R.id.activity_product_store);
        location = (TextView) findViewById(R.id.activity_product_location);
        phone = (TextView) findViewById(R.id.activity_product_phone);
        cancel = (Button) findViewById(R.id.activity_product_cancel);
        save = (Button) findViewById(R.id.activity_product_save);

        name.setText(item.getName());
        store.setText(item.getStore());
        location.setText(item.getLocation());
        phone.setText(item.getPhone());

        switch (item.getImage()){
            case 0:
                image.setImageResource(R.drawable.mac); break;
            case 1:
                image.setImageResource(R.drawable.alienware); break;
            case 2:
                image.setImageResource(R.drawable.pillows); break;
            case 3:
                image.setImageResource(R.drawable.sheets); break;
            case 4:
                image.setImageResource(R.drawable.refrigerator); break;
            case 5:
                image.setImageResource(R.drawable.micro); break;
            default:
                image.setImageResource(R.drawable.mac); break;
        }


    }

    public void onClickProduct(View v){
        switch (v.getId()){
            case R.id.activity_product_cancel:
                setResult(RESULT_CANCELED);
                break;
            case R.id.activity_product_save:
                item = getIntent().getParcelableExtra("ITEM");
                item.setName(name.getText().toString().trim());
                item.setStore(store.getText().toString().trim());
                item.setLocation(location.getText().toString().trim());
                item.setPhone(phone.getText().toString().trim());

                Intent intent = new Intent();
                intent.putExtra("ITEM", item);
                setResult(RESULT_OK, intent);
                break;
                default:
                    finish();
        }
        finish();
    }
}
