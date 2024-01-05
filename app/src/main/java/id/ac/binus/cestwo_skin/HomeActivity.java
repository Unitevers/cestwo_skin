package id.ac.binus.cestwo_skin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import id.ac.binus.cestwo_skin.model.Orders;

public class HomeActivity extends AppCompatActivity {
    ListView lv;
    DatabaseHelper db;
    ImageButton orderButton;
    Button sellBut, buyBut;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent pintent = getIntent();
        String name = pintent.getStringExtra("name");
        String orderdefault = pintent.getStringExtra("ordertype");

        TextView nameText = findViewById(R.id.userName);

        nameText.setText(name);

        orderButton = findViewById(R.id.placeBtn);
        orderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, OrderActivity.class);
                intent.putExtra("poster", name);
                startActivity(intent);
            }
        });

        db = new DatabaseHelper(this);
        lv = findViewById(R.id.lvData);
        Cursor cursor = db.getOrdersByType(orderdefault);
        StringBuffer buffer = new StringBuffer();

        ArrayList<Orders> orderList = new ArrayList<>();

        sellBut = findViewById(R.id.sellerButton);
        sellBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("ordertype", "Seller");
                startActivity(intent);
            }
        });

        buyBut = findViewById(R.id.buyerButton);

        buyBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("ordertype", "Buyer");
                startActivity(intent);
            }
        });

        while (cursor.moveToNext()) {
            String ordername = cursor.getString(1);
            String orderprice = cursor.getString(2);
            String ordertype = cursor.getString(3);
            String poster = cursor.getString(4);
            Orders order = new Orders(ordername, orderprice, ordertype, poster);
            orderList.add(order);
        }

        OrderAdapter ordAdapter = new OrderAdapter(this, R.layout.activity_categorylist_adapter, orderList);

        lv.setAdapter(ordAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomeActivity.this, "Trade request has been sent to user!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
