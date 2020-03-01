package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText fullName, userName, email, password, phone;
    RadioGroup gender;
    Button register, clickHere;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName=(EditText) findViewById(R.id.fullName);
        userName=(EditText) findViewById(R.id.userName);
        email= (EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        phone=(EditText) findViewById(R.id.phone);
        gender=(RadioGroup) findViewById(R.id.radioGroup);
        register=(Button) findViewById(R.id.buttonRegister);
        clickHere=(Button) findViewById(R.id.clickHereButton);
        databaseHelper = new DatabaseHelper(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullNameValues = fullName.getText().toString();
                String userNameValues = userName.getText().toString();
                String emailValues = email.getText().toString();
                String passwordValues = password.getText().toString();
                String phoneValues = phone.getText().toString();
                RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValues = checkedBtn.getText().toString();

                if(fullNameValues.length()>1){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("fullName", fullNameValues);
                    contentValues.put("userName", userNameValues);
                    contentValues.put("email", emailValues);
                    contentValues.put("password", passwordValues);
                    contentValues.put("phone", phoneValues);
                    contentValues.put("gender", genderValues);

                    databaseHelper.insertUser(contentValues);
                    Toast.makeText(RegisterActivity.this, "User Registered", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(RegisterActivity.this, "enter the values", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
