package id.ac.binus.cestwo_skin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText editName;
    EditText editUsername;
    EditText editPassword;
    EditText editAge;
    EditText editEmail;
    EditText editPhone;
    Button button_back;
    Button registerButton;
    Button loginButton;
    CheckBox checkTnC;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editName =findViewById(R.id.editName);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editAge = findViewById(R.id.editAge);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);

        button_back = findViewById(R.id.button_back);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);
        checkTnC = findViewById(R.id.checkTnC);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString();
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                String age = editAge.getText().toString();
                String email = editEmail.getText().toString();
                String phone = editPhone.getText().toString();

                boolean isInsert = db.isInsertUser(username, name, password, age, email, phone);
                if(isInsert){
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(RegisterActivity.this, "User failed to be created", Toast.LENGTH_LONG).show();
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
