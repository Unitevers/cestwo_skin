package id.ac.binus.cestwo_skin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import id.ac.binus.cestwo_skin.model.Orders;

public class OrderActivity extends AppCompatActivity {

    EditText editItemName, editItemPrice, editOrderType;
    ImageButton button_back;
    Button sellBtn, buyBtn, placeBtn;
    DatabaseHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        editItemName = findViewById(R.id.editName);
        editItemPrice = findViewById(R.id.editPrice);
        editOrderType = findViewById(R.id.editType);

        button_back = findViewById(R.id.button_back);
//        sellBtn = findViewById(R.id.sellBtn);
//        buyBtn = findViewById(R.id.buyBtn);
        placeBtn = findViewById(R.id.placeBtn);

        db = new DatabaseHelper(this);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

//        sellBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String sob = "Seller";
//                sellBtn.setBackgroundResource(R.drawable.button_color_change);
//                buyBtn.setBackgroundResource(R.drawable.button_color_change1);
//            }
//        });
//
//        buyBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String sob = "Buyer";
//                buyBtn.setBackgroundResource(R.drawable.button_color_change);
//                sellBtn.setBackgroundResource(R.drawable.button_color_change1);
//            }
//        });

        placeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = editItemName.getText().toString();
                String itemPrice = editItemPrice.getText().toString();
                String orderType = editOrderType.getText().toString();

//                Intent pintent = getIntent();
//                String sob = pintent.getStringExtra("sob");
                boolean isInsertOrd = db.isInsertOrder(itemName, itemPrice, orderType, "andre");
                if(isInsertOrd){
                    Toast.makeText(OrderActivity.this, "Order has been succesfully created", Toast.LENGTH_SHORT).show();
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
