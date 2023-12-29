package id.ac.binus.cestwo_skin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import id.ac.binus.cestwo_skin.model.Orders;

public class OrderActivity extends AppCompatActivity {

    EditText editItemName, editItemPrice;
    Button sellBtn, buyBtn, placeBtn;
    DatabaseHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        db = new DatabaseHelper(this);
        ArrayList<Orders> arr = new ArrayList<>();
        Orders order;

        editItemName = findViewById(R.id.editName);
        editItemPrice = findViewById(R.id.editPrice);

        sellBtn = findViewById(R.id.sellBtn);
        buyBtn = findViewById(R.id.buyBtn);
        placeBtn = findViewById(R.id.placeBtn);

        placeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = editItemName.getText().toString();
                String itemPrice = editItemPrice.getText().toString();
                boolean isInsert = db.isInsertOrder(itemName, itemPrice);

                if(isInsert){
                    Intent intent = new Intent(OrderActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(OrderActivity.this, "Create Order Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
