package com.example.apple.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ToCreate = (TextView) findViewById(R.id.tocreateacount);
        ToCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),createAccount.class);
                startActivity(in);

            }
        });
    }

    public void usrLogIn(View V) {
        EditText Email =  findViewById(R.id.InputEmail);
        EditText password =  findViewById(R.id.InputPass);
        String user = Email.getText().toString();
        String pass = password.getText().toString();

        SharedPreferences usrAccounts = getSharedPreferences("UsersAccounts", 0);

        if (!usrAccounts.contains(user)){
            Toast.makeText(getApplicationContext(), "لا يوجد مستخدم بهذا الأسم",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if (usrAccounts.getString(user, null).equals(pass))
            Toast.makeText(getApplicationContext(), "تم تسجيل الدخول",Toast.LENGTH_LONG).show();

        else
            Toast.makeText(getApplicationContext(), "كلمة السر غير صحيحة ", Toast.LENGTH_LONG).show();


    }



}
