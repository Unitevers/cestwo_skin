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
        placeBtn = findViewById(R.id.placeBtn);

        db = new DatabaseHelper(this);
        Intent pintent = getIntent();
        String poster = pintent.getStringExtra("poster");

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderActivity.this, HomeActivity.class);
                intent.putExtra("name", poster);
                startActivity(intent);
            }
        });

        placeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = editItemName.getText().toString();
                String itemPrice = editItemPrice.getText().toString();
                String orderType = editOrderType.getText().toString();

                boolean isInsert = db.isInsertOrder(itemName, itemPrice, orderType, poster);
                if(isInsert){
                    Toast.makeText(OrderActivity.this, "Order has been succesfully created", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(OrderActivity.this, HomeActivity.class);
                    intent.putExtra("name", poster);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(OrderActivity.this, "Create Order Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
