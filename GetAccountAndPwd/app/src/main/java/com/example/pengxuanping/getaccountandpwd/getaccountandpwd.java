package com.example.pengxuanping.getaccountandpwd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class getaccountandpwd extends AppCompatActivity {

    private EditText account;
    private EditText password;

    @Override
    /* key points: class & obj;  new obj, obj.method, obj.field; */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getaccountandpwd);
        Button bt_login;
        account = (EditText) findViewById(R.id.et_accnt); //cast enter + alt, enter
        password = (EditText) findViewById(R.id.et_pwd);/* use parent class method */
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new MyListener());

    }

    private class MyListener implements View.OnClickListener { /* class include interface class.interface*/
        public void onClick(View v) {
            String accnt = account.getText().toString().trim();
            /* 1. textview obj.getText() return textView obj;
               2. textView.toStrig(inherit parent class method) return String obj;
               3. String.trim() return String obj */
            String pwd = password.getText().toString().trim();
            if (!TextUtils.isEmpty(accnt) && !TextUtils.isEmpty(pwd)) {
                Toast.makeText(getaccountandpwd.this, accnt + "+" + pwd, Toast.LENGTH_SHORT).show();
            }
        }

    }

}
