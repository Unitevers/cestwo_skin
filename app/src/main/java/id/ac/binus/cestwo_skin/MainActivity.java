package id.ac.binus.cestwo_skin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editName;
    EditText editPassword;
    Button loginButton;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.logName);
        editPassword = findViewById(R.id.logPassword);
        loginButton = findViewById(R.id.loginButton);

        db = new DatabaseHelper(this);

        TextView textView = findViewById(R.id.register);

        String text = "Don't have an account? Register here";

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan, 23, 36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();

                if(name.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "Must fill all the fields!", Toast.LENGTH_LONG).show();
                }
                else{
                    boolean checkuser = db.checknamepassword(name, password);
                    if(checkuser){
                        Toast.makeText(MainActivity.this, "You have succesfully logged in", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("name", name);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "User does not exist!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}