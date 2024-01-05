package id.ac.binus.cestwo_skin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
//    ListView lv;
    DatabaseHelper db;
    ImageButton orderButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = new DatabaseHelper(this);
//        lv = findViewById(R.id.lvData);
//        Cursor cursor = db.getOrdersByType("Seller");
//        StringBuffer buffer = new StringBuffer();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView nameText = findViewById(R.id.userName);

        nameText.setText(name);

        orderButton = findViewById(R.id.placeBtn);
        orderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, OrderActivity.class);
//                intent.putExtra("sob", name);
                startActivity(intent);
            }
        });
    }
}
