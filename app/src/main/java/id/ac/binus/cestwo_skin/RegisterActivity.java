package id.ac.binus.cestwo_skin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText editName;
    EditText editUsername;
    EditText editAge;
    EditText editEmail;
    EditText editPhone;
    Button button_back;
    Button registerButton;
    CheckBox checkTnC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editName =findViewById(R.id.editName);
        editUsername = findViewById(R.id.editUsername);
        editAge = findViewById(R.id.editAge);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);

        button_back = findViewById(R.id.button_back);
        registerButton = findViewById(R.id.registerButton);
        checkTnC = findViewById(R.id.checkTnC);

    }
}
