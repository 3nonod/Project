package com.example.apple.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class createAccount extends AppCompatActivity {
    SharedPreferences usrAccs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }


    public void signUp(View V){
        EditText Name =(EditText) findViewById(R.id.inputName);
        EditText Email =(EditText) findViewById(R.id.inputEmail);
        EditText Pass =(EditText) findViewById(R.id.inputpass);
        EditText Phone =(EditText) findViewById(R.id.inputPhone);
        EditText Birth =(EditText) findViewById(R.id.inputBirth);

        usrAccs = getApplicationContext().getSharedPreferences("UserAccounts",0);

        SharedPreferences.Editor usrAccsEditor = usrAccs.edit();

        if (usrAccs.contains(Email.getText().toString())){
            Toast.makeText(getApplicationContext(),"البريد الألكتروني مستخدم مسبقاً",
                    Toast.LENGTH_LONG).show();
            return;
        }
        usrAccsEditor.putString(Name.getText().toString(),Pass.getText().toString());
        usrAccsEditor.commit();

        Toast.makeText(getApplicationContext(),usrAccs.getString(Name.getText().toString(),null)
                        +" تم إنشاء الحساب",
                Toast.LENGTH_LONG).show();


        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();

    }
}

