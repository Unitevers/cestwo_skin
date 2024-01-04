package id.ac.binus.cestwo_skin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = new DatabaseHelper(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView nameText = findViewById(R.id.userName);

        nameText.setText(name);
    }
}
