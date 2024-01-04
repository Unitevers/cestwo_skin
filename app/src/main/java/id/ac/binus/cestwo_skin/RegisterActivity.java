package id.ac.binus.cestwo_skin;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText editName;
    EditText editPassword;
    EditText editCPassword;
    ImageButton button_back;
    Button registerButton;
//    Button loginButton;
//    CheckBox checkTnC;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName =findViewById(R.id.editName);
        editPassword = findViewById(R.id.editPassword);
        editCPassword = findViewById(R.id.editCPassword);

        button_back = findViewById(R.id.button_back);
        registerButton = findViewById(R.id.registerButton);
//        checkTnC = findViewById(R.id.checkTnC);
        db = new DatabaseHelper(this);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        CheckBox checkBox = findViewById(R.id.checkTnC);

//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked)
//                    Toast.makeText(RegisterActivity.this,"agreed",Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(RegisterActivity.this,"not Agreed",Toast.LENGTH_SHORT).show();
//
//            }
//        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                String cpassword = editCPassword.getText().toString();
                if(name.equals("") || password.equals("") || cpassword.equals("")){
                    Toast.makeText(RegisterActivity.this, "Must fill all the fields!", Toast.LENGTH_LONG).show();
                }
                else{
                    if(password.equals(cpassword)) {
                        boolean checkusername = db.checkname(name);
                        if(checkusername == false){
                            boolean isInsert = db.isInsertUser(name, password);
                            if(isInsert){
                                Toast.makeText(RegisterActivity.this, "User has succesfully been registered", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else{
                                Toast.makeText(RegisterActivity.this, "User failed to be created", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Name already exist!", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Password and confirm password must be the same!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        TextView textView = findViewById(R.id.login);

        String text = "Already have account? Then Login Now";

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan, 27, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


    }

//    public void onCheckboxClicked(View view){
//        boolean checked = ((CheckBox) view).isChecked();
//        switch(view.getId()){
//            case R.id.checkTnC:
//                if(checked)
//                    Toast.makeText(this, "agreed", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(this, "not agreed", Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }
}
